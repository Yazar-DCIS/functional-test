package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_9 extends WizardPage {

	private YesNo proceedings;
	private Address immigrationAddress;
	private MultiRadioOptions immigrationType;
	private AdditionalInfoFields immigrationLocation;

	public SQ2_9(WebDriver driver) {
		super(driver);
	}

	public SQ2_9 immigrationProceedings(String currentlyExclusionProceedings,
			String underImmigrationProceedings,String immigrationProceedingsType)
	{
		
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		proceedings = new YesNo(driver,"applicant.currentlyExclusionProceedings");
		
		if(currentlyExclusionProceedings.equalsIgnoreCase("Yes"))
		{
			proceedings.yes();	
		}
		else if(currentlyExclusionProceedings.equalsIgnoreCase("No"))
		{
			proceedings.no();	
			
			proceedings = new YesNo(driver, "applicant.underImmigrationProceedings");
			
			if(underImmigrationProceedings.equalsIgnoreCase("Yes"))
			{
				
				proceedings.yes();	
				
				immigrationAddress = new Address(driver,"applicationData-applicant.immigrationProceedingsPlace");
				immigrationAddress.setCity(i130i485.getProperty("applicant.immigrationProceedingsPlace.city"));
				immigrationAddress.setState(i130i485.getProperty("applicant.immigrationProceedingsPlace.state"));
				
				immigrationLocation = new AdditionalInfoFields(driver,"applicationData-applicant.immigrationProceedingsPlace");
				immigrationLocation.normalText(i130i485.getProperty("applicant.immigrationProceedingsPlace.location"));
				
				
				immigrationType = new MultiRadioOptions(driver,"applicationData-applicant.immigrationProceedingsType");
				if(immigrationProceedingsType.equalsIgnoreCase("Removal"))
				{
					immigrationType.selectOption(1);
				}
				else if(immigrationProceedingsType.equalsIgnoreCase("Exclusion"))
				{
					immigrationType.selectOption(2);
				}
				else if(immigrationProceedingsType.equalsIgnoreCase("Rescission"))
				{
					immigrationType.selectOption(3);
				}
				else if(immigrationProceedingsType.equalsIgnoreCase("Judicial "))
				{
					immigrationType.selectOption(4);
				}
				
				
			}
			else if(underImmigrationProceedings.equalsIgnoreCase("No"))
			{
				proceedings.no();	
			}
			
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

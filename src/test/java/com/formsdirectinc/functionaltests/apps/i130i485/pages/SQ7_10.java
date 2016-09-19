package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_10 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_10 extends WizardPage {

	private YesNo previouslyApplied,livedUnlawfully,livedWithoutStatus;

	public SQ7_10(WebDriver driver) {
		super(driver);
	}

	public SQ7_10 relativeImmigrationStatus(String hasPreviouslyApplied,String hasLivedUnlawfully,String hasLivedWithoutStatus) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		previouslyApplied = new YesNo(driver,
				"foreignRelative.immigrationHistory.previouslyApplied");
		
		if(hasPreviouslyApplied.equalsIgnoreCase("Yes"))
		{
			previouslyApplied.yes();
			DateTag appliedDate=new DateTag(driver, "foreignRelative.immigrationHistory.dateApplied");
			appliedDate.selectDate(i130i485.getProperty("foreignRelative.immigrationHistory.dateApplied"));
			
			AdditionalInfoFields applicationStatus=new AdditionalInfoFields(driver, "applicationData-foreignRelative.immigrationHistory");
			applicationStatus.setOfficeApplied(i130i485.getProperty("foreignRelative.immigrationHistory.officeApplied"));
			applicationStatus.setFinalDecision(i130i485.getProperty("foreignRelative.immigrationHistory.finalDecision"));
			
		}
		else if(hasPreviouslyApplied.equalsIgnoreCase("No"))
		{
			previouslyApplied.no();
		}
	
		livedUnlawfully = new YesNo(driver,
				"foreignRelative.immigrationHistory.livedUnlawfully");
		if(hasLivedUnlawfully.equalsIgnoreCase("Yes"))
		{
			livedUnlawfully.yes();
			livedWithoutStatus = new YesNo(driver,
					"foreignRelative.immigrationHistory.livedWithoutStatus");
			livedWithoutStatus.setYesOrNo(hasLivedWithoutStatus);
			
		}
		else if(hasLivedUnlawfully.equalsIgnoreCase("no"))
		{
			livedUnlawfully.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

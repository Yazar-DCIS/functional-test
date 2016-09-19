package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.OtherNames;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	private YesNo usedOtherNames;
	private Gender gender;
	private OtherNames moreNames; 
	
	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 biographicInfo(String haveOtherNames, int count,String genderIs) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		usedOtherNames = new YesNo(driver,	"applicant.othernames.haveUsedOtherNames");
		usedOtherNames.setYesOrNo(haveOtherNames);
		
		if(haveOtherNames.equalsIgnoreCase("yes"))
		{
			for (int i = 0; i < count; i++) {
			
				moreNames= new OtherNames(driver,"applicationData-applicant.othernames.appOtherNames["+i+"]");
				moreNames.setOtherName(i130i485.getProperty("applicant.othernames.appOtherNames["+i+"].first"));
			
				if (i < count - 1) {
					CommonInputClasses otherName = new CommonInputClasses(
							driver);
					otherName.addAnother();
				}
				
			}
			
			
		}
		
		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGender(genderIs);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

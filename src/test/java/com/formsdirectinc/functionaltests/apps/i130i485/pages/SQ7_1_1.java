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
 * Page model for SQ7_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_1_1 extends WizardPage {

	private YesNo usedOtherNames;
	private Gender gender;

	public SQ7_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_1_1 relativeBiographicInfo(String haveUsedOtherNames,int otherNamesCount,String genderIs) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		usedOtherNames = new YesNo(driver,
				"foreignRelative.othernames.haveUsedOtherNames");
		if(haveUsedOtherNames.equalsIgnoreCase("Yes"))
		{
			usedOtherNames.yes();
			for(int i=0;i<otherNamesCount;i++)
			{
				OtherNames otherNames=new OtherNames(driver, "applicationData-foreignRelative.othernames.appOtherNames["+i+"]");
				otherNames.setOtherName(i130i485.getProperty("foreignRelative.othernames.appOtherNames["+i+"]"));
				
				if (i < otherNamesCount - 1) {
					CommonInputClasses addAnotherSpouse=new CommonInputClasses(driver);
					addAnotherSpouse.addAnother();
				}
				
			}
			
		}
		else if(haveUsedOtherNames.equalsIgnoreCase("No"))
		{
			usedOtherNames.no();
		}
		
		gender = new Gender(driver, "applicationData-foreignRelative.sex");
		gender.setGender(genderIs);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

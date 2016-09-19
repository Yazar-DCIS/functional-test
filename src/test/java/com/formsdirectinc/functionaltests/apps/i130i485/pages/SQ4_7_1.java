package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_7_1 extends WizardPage {

	private YesNo arn;
	private Numbers alienNumber;

	public SQ4_7_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_7_1 arnDetails(String haveArn) {
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		arn = new YesNo(driver, "applicant.haveARNNumber");
		arn.setYesOrNo(haveArn);
		if(haveArn.equalsIgnoreCase("Yes"))
		{
			alienNumber= new Numbers(driver, "applicationData-applicant.arnNumber");
			alienNumber.setAlienRegistrationNumber(i130i485.getProperty("applicant.arnNumber.ARN"));
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

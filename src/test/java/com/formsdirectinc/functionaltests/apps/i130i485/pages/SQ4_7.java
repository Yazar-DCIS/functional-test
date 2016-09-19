package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_7 extends WizardPage {

	private Numbers securityNumber;

	public SQ4_7(WebDriver driver) {
		super(driver);
	}

	public SQ4_7 ssnDetails() {
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		securityNumber = new Numbers(driver, "applicationData-applicant.SSN");
		securityNumber.setSocialSecurityNumber(i130i485.getProperty("applicant.SSN.ssn1"), 
				i130i485.getProperty("applicant.SSN.ssn2"), 
				i130i485.getProperty("applicant.SSN.ssn3"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

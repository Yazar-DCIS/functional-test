package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast applicantName;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 applicantName() {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		applicantName = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		applicantName.setFirstNameField(i130i485.getProperty("applicant.name.first"));
		applicantName.setLastNameField(i130i485.getProperty("applicant.name.last"));
		return this;
	}

}

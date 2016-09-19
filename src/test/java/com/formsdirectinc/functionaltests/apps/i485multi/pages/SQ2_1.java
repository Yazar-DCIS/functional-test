package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_1 extends WizardPage {

	
	

	private Name_FirstMiddleLast applicantName;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public void applicantNameDetails(Properties data) {

		applicantName = new Name_FirstMiddleLast(driver, "applicationData",
				"principalApplicant.name");
		applicantName.setFirstNameField(data.getProperty("FirstName"));
		applicantName.setLastNameField(data.getProperty("LastName"));

	}

}

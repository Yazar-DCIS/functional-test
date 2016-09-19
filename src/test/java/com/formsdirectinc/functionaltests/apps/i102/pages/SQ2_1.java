package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private Name_FirstMiddleLast nameTag;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1 setNameFields(Properties data) {

		nameTag = new Name_FirstMiddleLast(driver, "applicationData",
				"applicantInfo.name");
		nameTag.setFirstNameField(data.getProperty("FirstName"));
		nameTag.setMiddleNameField(data.getProperty("MiddleName"));
		nameTag.setLastNameField(data.getProperty("LastName"));

		saveScreenShot("I102", "SQ2_1"); clickContinueInSQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {
	private Name_FirstMiddleLast name;
	private Gender genderSelect;

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 nameAndGender(Properties data) {

		
		name = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		name.setFirstNameField(data.getProperty("FirstName0"));
		name.setMiddleNameField(data.getProperty("MiddleName0"));
		name.setLastNameField(data.getProperty("LastName0"));

		genderSelect = new Gender(driver, "applicationData-applicant.sex");
		genderSelect.setGenderAsMale();

		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}
}

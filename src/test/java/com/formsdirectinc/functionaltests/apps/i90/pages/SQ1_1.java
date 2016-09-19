package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;

/**
 * @author Orina
 *
 */
public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast nameTag;
	private Gender gender;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 nameandgender(Properties data, String haveMiddleName, String genderIs) {

		nameTag = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		
		nameTag.setApplicantNameDetails(data.getProperty("applicant.name.first"),
				data.getProperty("applicant.name.last"), 
				haveMiddleName, 
				data.getProperty("applicant.name.middle"));
		
		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGender(genderIs);

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

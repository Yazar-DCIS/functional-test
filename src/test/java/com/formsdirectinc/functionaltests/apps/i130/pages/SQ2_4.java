package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_4 extends WizardPage {

	private Gender gender;

	public SQ2_4(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SQ2_4 relativeGender(String genderIs) {

		if (genderIs.equalsIgnoreCase("Male")||genderIs.equalsIgnoreCase("Female")) {
			gender = new Gender(driver, "applicationData-relative.sex");
			gender.setGender(genderIs);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

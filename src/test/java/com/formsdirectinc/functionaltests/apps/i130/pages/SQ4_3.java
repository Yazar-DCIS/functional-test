package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_3 extends WizardPage {

	private Gender gender;

	public SQ4_3(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SQ4_3 spouseGender(String genderIs) {

		if (genderIs.equalsIgnoreCase("female")||genderIs.equalsIgnoreCase("male")) {
			gender = new Gender(driver, "applicationData-spouseInfo.sex");
			gender.setGender(genderIs);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

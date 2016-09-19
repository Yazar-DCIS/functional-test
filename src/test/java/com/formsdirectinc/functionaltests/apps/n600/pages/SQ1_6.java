package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6 extends WizardPage {

	public Gender gender;
	public PhysicalTraits heightValues;
	public PhysicalTraits heightOptions;

	public SQ1_6(WebDriver driver) {
		super(driver);

	}

	public SQ1_6 physicalTraits(String genderType, String heightType,
			Properties data) {

		if (!genderType.equalsIgnoreCase("NA")
				&& !heightType.equalsIgnoreCase("NA")) {
			gender = new Gender(driver, "applicationData-applicant.sex");
			gender.setGender(genderType);

			heightOptions = new PhysicalTraits(driver, "applicationData",
					"applicant.height.heightoption");
			if (heightType.equalsIgnoreCase("english")) {
				heightOptions.heightEnglish();
				heightValues = new PhysicalTraits(driver, "applicationData",
						"applicant.height");
				heightValues.setHeightinFeet(data.getProperty("Feet"));
				heightValues.setHeightinInches(data.getProperty("Inches"));
			}
			else if (heightType.equalsIgnoreCase("metric")) {
				heightOptions.heightMetric();
				heightValues = new PhysicalTraits(driver, "applicationData",
						"applicant.height");
				heightValues.setHeightinCentimetre(data
						.getProperty("Centimeters"));
			}
			saveScreenShot("n600", "SQ1_6"); clickContinueInSQ();
		}
		return this;
	}

}

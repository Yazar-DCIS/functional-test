package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4_1 extends WizardPage {

	private MultiRadioOptions race, hairColor, eyeColor;
	private YesNo hispanicLatino;
	private PhysicalTraits english;
	private AdditionalInfoFields applicantWeight;

	public SQ1_4_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_4_1 physicalTraits(Properties data) {

		english = new PhysicalTraits(driver, "applicationData",
				"applicationData-applicant.height");
		english.selectHeightinFeet_i90(data.getProperty("Feet"));
		english.selectHeightinInches_i90(data.getProperty("Inches"));

		applicantWeight = new AdditionalInfoFields(driver,
				"applicationData-applicant.weight.pounds");
		applicantWeight.normalText(data.getProperty("Weight"));

		race = new MultiRadioOptions(driver,
				"applicationData-applicant.raceList[1].race");
		race.selectOption(1);

		hairColor = new MultiRadioOptions(driver,
				"applicationData-applicant.hairColor");
		hairColor.selectOption(1);

		eyeColor = new MultiRadioOptions(driver,
				"applicationData-applicant.eyeColor");
		eyeColor.selectOption(1);

		hispanicLatino = new YesNo(driver, "applicant.hispanicorLatino");
		hispanicLatino.yes();

		saveScreenShot("i751", "SQ1_4_1"); clickContinueInSQ();

		return this;
	}
}

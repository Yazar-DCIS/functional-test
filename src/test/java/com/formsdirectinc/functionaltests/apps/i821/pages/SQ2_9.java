package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_9 extends WizardPage {

	public SQ2_9(WebDriver driver) {
		super(driver);
	}

	
	private AdditionalInfoFields feet;
	private AdditionalInfoFields pounds;
	private AdditionalInfoFields inches;
	private MultiRadioOptions eyeColor;
	private MultiRadioOptions hairColor;
	private YesNo hispanic;
	private CheckBox race;

	public SQ2_9 physical_Traits(String hispanicOrLatino, Properties data) {
		if (!hispanicOrLatino.equalsIgnoreCase("NA")) {
			feet = new AdditionalInfoFields(driver,
					"applicationData-applicant.height.feet");
			feet.normalText(data.getProperty("Feet"));

			inches = new AdditionalInfoFields(driver,
					"applicationData-applicant.height.inches");
			inches.normalText(data.getProperty("Inches"));

			pounds = new AdditionalInfoFields(driver,
					"applicationData-applicant.weight.pounds");
			pounds.normalText(data.getProperty("Weight"));

			eyeColor = new MultiRadioOptions(driver,
					"applicationData-applicant.eyeColor");
			eyeColor.selectOption(1);

			hairColor = new MultiRadioOptions(driver,
					"applicationData-applicant.hairColor");
			hairColor.selectOption(1);

			hispanic = new YesNo(driver, "applicant.hispanicOrLatino");
			hispanic.setYesOrNo(hispanicOrLatino);

			race = new CheckBox(driver,
					"applicationData-applicant.raceList[1].race-1");
			race.check();

			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

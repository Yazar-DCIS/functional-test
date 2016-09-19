package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4_2 extends WizardPage {
	private PhysicalTraits applicantHeight, applicantWeight;
	private MultiRadioOptions applicantColor;
	private YesNo hispanic;

	public SQ2_4_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_4_2 applicantPhysicalTraits(Properties data) throws Exception {
		applicantHeight = new PhysicalTraits(driver, "applicationData",
				"applicant.physicalTraits.height");
		applicantHeight.selectHeightinFeet(data.getProperty("Feet"));
		applicantHeight.selectHeightinInches(data.getProperty("Inches"));

		applicantWeight = new PhysicalTraits(driver, "applicationData",
				"applicationData-applicant.physicalTraits.weight");
		applicantWeight.setWeightinPounds(data.getProperty("Weight"));

		applicantColor = new MultiRadioOptions(driver,
				"applicationData-applicant.physicalTraits.eyeColor");
		applicantColor.selectOption(1);

		applicantColor = new MultiRadioOptions(driver,
				"applicationData-applicant.physicalTraits.hairColor");
		applicantColor.selectOption(1);

		hispanic = new YesNo(driver, "applicant.hispanicOrLatino");
		hispanic.no();

		applicantColor = new MultiRadioOptions(driver,
				"applicationData-applicant.raceList[1].race");
		applicantColor.selectOption(1);

		return this;

	}

}

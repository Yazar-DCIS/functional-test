package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_5 extends WizardPage {

	protected MultiRadioOptions immigrationStatus;
	protected AdditionalInfoFields otherExplain;

	public SQ3_5(WebDriver driver) {
		super(driver);

	}

	public SQ3_5 immigrationStatus_part1(Properties data, String immigrantType) {

		if (!immigrantType.equalsIgnoreCase("NA")) {
			immigrationStatus = new MultiRadioOptions(driver,

			"applicationData-applicant.additionalInfo.immigrationStatus");

			if (immigrantType.equalsIgnoreCase("lawfulResident")) {
				immigrationStatus.selectOption(1);
			}

			else if (immigrantType.equalsIgnoreCase("nonImmigrant")) {
				immigrationStatus.selectOption(2);
			}

			else if (immigrantType.equalsIgnoreCase("refugee")) {
				immigrationStatus.selectOption(3);
			}

			else if (immigrantType.equalsIgnoreCase("other")) {
				immigrationStatus.selectOption(4);
				otherExplain = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.otherImmigrationStatus");
				otherExplain.isStatusOther(data.getProperty("Reasons"));
			}
			saveScreenShot("n600", "SQ3_5"); clickContinueInSQ();
		}
		return this;
	}

}

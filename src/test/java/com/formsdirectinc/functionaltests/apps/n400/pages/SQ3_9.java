package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_9 extends WizardPage {

	private MultiRadioOptions spouseImmigration;
	private Country spouseCountry;
	private AdditionalInfoFields reasons;

	public SQ3_9(WebDriver driver) {
		super(driver);

	}

	public SQ3_9 spouseImmigrationDetails(Properties copies, Properties data,
			String immigrationStatus) {

		if (!immigrationStatus.equalsIgnoreCase("NA")) {

			spouseCountry = new Country(driver,
					"applicationData-currentSpouse.countryOfCitizenship");
			spouseCountry.setCountryDDM(data.getProperty("Country"));

			spouseImmigration = new MultiRadioOptions(driver,

			"applicationData-currentSpouse.immigrationStatus");

			if (immigrationStatus.equalsIgnoreCase("permanentResident")) {
				spouseImmigration.selectOption(1);
			}
			else if (immigrationStatus.equalsIgnoreCase("other")) {
				spouseImmigration.selectOption(2);

				reasons = new AdditionalInfoFields(driver,
						"applicationData-currentSpouse.otherImmigrationStatus");
				reasons.normalText("none");
			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_9");
			
			 clickContinueInSQ();
		}
		return this;
	}

}

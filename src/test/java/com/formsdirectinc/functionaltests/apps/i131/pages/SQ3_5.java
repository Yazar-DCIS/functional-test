package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_5 extends WizardPage {
	private AdditionalInfoFields countryToVisit;

	public SQ3_5(WebDriver driver) {
		super(driver);
	}

	public SQ3_5 countryToVisit(Properties data, String country) {
		if (!country.equalsIgnoreCase("NA")) {
			
			countryToVisit = new AdditionalInfoFields(driver,

			"applicationData-applicant.plannedCountriesToVisit");
			countryToVisit.normalText(data.getProperty("I131_EmbassyCountry"));
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

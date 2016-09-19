package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1 extends WizardPage {
	private Address countrySelect;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 refugeeCountry(Properties data, String country) {
		if (!country.equalsIgnoreCase("NA")) {
			
			countrySelect = new Address(driver,
					"applicationData-applicant.refugeeOrAsyleeCountry");
			countrySelect.setCountryDropDown(data
					.getProperty("I131_EmbassyCountry"));
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	private DateTag dateOfBirth;
	private Country countryOfBirth;
	private Country citizenOfCountry;

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public void set_DateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));
	}

	public void set_CountryOfBirth(Properties data) {
		countryOfBirth = new Country(driver,
				"applicationData-applicant.birth.countryOfBirth");
		countryOfBirth.setCountryDDM(data.getProperty("Country"));
	}

	public void set_CitizenOfCountry(Properties data) {
		citizenOfCountry = new Country(driver,
				"applicationData-applicant.citizenOfCountry");
		citizenOfCountry.setCountryDDM(data.getProperty("Country"));
	}

}

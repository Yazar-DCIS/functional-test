package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_4 extends WizardPage {
	private DateTag applicantDOB;
	private Country applicantCountry;

	public SQ4_4(WebDriver driver) {
		super(driver);

	}

	public void applicantBirthDetails(Properties data) {
		applicantDOB = new DateTag(driver, "applicant.birth.dateOfBirth");
		applicantDOB.selectDate(data.getProperty("DOB"));

		applicantCountry = new Country(driver,
				"applicationData-applicant.birth.countryOfBirth");
		applicantCountry.setCountryDDM(data.getProperty("Country"));
		
		
		applicantCountry = new Country(driver,
				"applicationData-applicant.birth.countryOfBirth");
		applicantCountry.setCountryDDM(data.getProperty("Country"));

		applicantCountry = new Country(driver,
				"applicationData-applicant.nationality");
		applicantCountry.setCountryDDM(data.getProperty("Country"));

	}

}

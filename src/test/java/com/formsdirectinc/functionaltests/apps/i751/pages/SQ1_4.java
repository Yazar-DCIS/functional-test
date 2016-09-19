package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4 extends WizardPage {

	private DateTag dateOfBirth;
	private Country applicantCountry;
	private CommonInputClasses addresstag;

	public SQ1_4(WebDriver driver) {
		super(driver);

	}

	public void setBirthDetails(Properties data) {
		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));

		applicantCountry = new Country(driver,
				"applicationData-applicant.birth.countryOfBirth");
		applicantCountry.setCountryDDM(data.getProperty("Country"));

	}

	public void setCountryDetailsUpdated(Properties data) {
		applicantCountry = new Country(driver,
				"applicationData-applicant.countryOfCitizenship[0].country");
		applicantCountry.setCountryDDM(data.getProperty("Country"));
	}

	public void setCountryDetailsOld(Properties data) {
		applicantCountry = new Country(driver,
				"applicationData-applicant.countryOfCitizenship");
		applicantCountry.setCountryDDM(data.getProperty("Country"));
	}

	public void setNumberFields(Properties data) {

		addresstag = new CommonInputClasses(driver);
		addresstag.applicantNumberDetails(
				"applicationData-applicant.contactMethods", data);

	}
}

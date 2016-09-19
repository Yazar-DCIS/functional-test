package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4 extends WizardPage {

	private Address applicantAddress;
	private Country applicantCountry;
	private DateTag dateOfBirth;
	private Gender gender;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 applicantCurrentAddress(Properties data) throws Exception {

		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGenderAsFemale();

		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDateAsSingle(data.getProperty("DateOfBirth"));

		applicantAddress = new Address(driver,
				"applicationData-applicant.placeOfBirth");
		applicantAddress.setCity(data.getProperty("City"));

		applicantAddress = new Address(driver,
				"applicationData-applicant.placeOfBirth.country");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-applicant.nationality");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantCountry = new Country(driver,
				"applicationData-applicant.residence");
		applicantCountry.setCountryDDM(data.getProperty("DACA_Country"));

		return this;

	}
}

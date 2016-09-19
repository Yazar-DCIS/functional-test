package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4 extends WizardPage {

	private Address addressDetails;
	private Country countryDetails;
	private Gender genderDetails;
	private DateTag applicantDOB;

	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_4 applicantBirthDetails(Properties data) throws Exception {
		
		applicantDOB = new DateTag(driver, "applicant.birth.dateOfBirth");
		applicantDOB.selectDate(data.getProperty("DOB"));

		addressDetails = new Address(driver,
				"applicationData-formSpecific.placeOfBirth");
		addressDetails.setCity(data.getProperty("City765"));
		addressDetails.setBirthState(data.getProperty("State"));

		countryDetails = new Country(driver,
				"applicationData-applicant.countryOfCitizenship");
		countryDetails.setCountryDDM(data.getProperty("Country"));

		countryDetails = new Country(driver,
				"applicationData-formSpecific.placeOfBirth.country");
		countryDetails.setCountryDDM(data.getProperty("Country"));

		genderDetails = new Gender(driver, "applicationData-applicant.sex");
		genderDetails.setGenderAsFemale();

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}
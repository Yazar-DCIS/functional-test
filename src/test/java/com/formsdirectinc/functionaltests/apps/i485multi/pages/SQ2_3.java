package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	
	

	private Address applicantAddress;
	private DateTag dateOfBirth;
	private Gender gender;

	public SQ2_3(WebDriver driver) {
		super(driver);

	}

	public void biographicalInformation(Properties data) {

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.birth.countryOfBirth");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.countryOfCitizenship");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.birth");
		applicantAddress.setCityOfBirth(data.getProperty("City"));

		dateOfBirth = new DateTag(driver,
				"principalApplicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));

		gender = new Gender(driver, "applicationData-principalApplicant.sex");
		gender.setGenderAsFemale();

		PhoneNumber applicantNumber = new PhoneNumber(driver,
				"applicationData-principalApplicant.phoneExt");
		applicantNumber.setPhoneCode(data.getProperty("Phone1"));
		applicantNumber.setPhoneNumber(data.getProperty("Phone2"));

	}

	public void beneficiaryBiographicalInformation(Properties data) {

		applicantAddress = new Address(driver,
				"applicationData-beneficiaryApplicant.birth.countryOfBirth");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-beneficiaryApplicant.countryOfCitizenship");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-beneficiaryApplicant.birth");
		applicantAddress.setCityOfBirth(data.getProperty("City"));

		dateOfBirth = new DateTag(driver,
				"beneficiaryApplicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("spouseDOB"));

		gender = new Gender(driver, "applicationData-beneficiaryApplicant.sex");
		gender.setGenderAsMale();

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-beneficiaryApplicant.USAddress");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));
	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.By;
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

	private Address addressFields;
	private Address countryOfBirth;
	private Address countryOfCitizenship;
	private DateTag dateOfBirth;
	private Gender gender;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public void setDateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));
	}

	public void setAddress(Properties data) {
		addressFields = new Address(driver,
				"applicationData-applicant.placeOfBirth");
		addressFields.setVisaCity(data.getProperty("City"));
		driver.findElement(
				By.id("applicationData-applicant.placeOfBirth.state"))
				.sendKeys("Kansas");
		countryOfBirth = new Address(driver,
				"applicationData-applicant.birth.countryOfBirth");
		countryOfBirth.setCountry(data.getProperty("DOB_Country"));
		countryOfCitizenship = new Address(driver,
				"applicationData-applicant.countryOfCitizen");
		countryOfCitizenship.setCountry(data.getProperty("DOB_Country"));
	}

	public void genderMaleFemale(Properties data) {
		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGenderAsMale();
	}

	public void setNumberFields(Properties data) {

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.homeAddress");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

	}

}
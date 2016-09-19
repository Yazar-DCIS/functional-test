package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	private CommonInputClasses nameTag;
	private CommonInputClasses applicantAddress;
	public Address applicantCountry;
	private DateTag dateOfBirthSpouse;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public void setNameFields(Properties data) {
		nameTag = new CommonInputClasses(driver);
		nameTag.applicantNameDetails("jointSpouse.name", data);

	}

	public SQ2_2 applicantResidenceDetails(Properties data) {
		applicantAddress = new CommonInputClasses(driver);
		applicantAddress.applicantOtherAddressDetails(
				"applicationData-jointSpouse.homeAddress", data);

		return this;
	}

	public void applicantResidenceCountry(Properties data) {

		applicantCountry = new Address(driver,
				"applicationData-jointSpouse.homeAddress.country");
		applicantCountry.setCountryDropDown(data.getProperty("Country"));

	}

	public void setBirthDetails(Properties data) {
		dateOfBirthSpouse = new DateTag(driver, "jointSpouse.dateOfBirth");
		dateOfBirthSpouse.selectDate(data.getProperty("DOB"));

	}

	public void setContactDetails(Properties data) {
		PhoneNumber number = new PhoneNumber(driver,
				"applicationData-jointSpouse");
		number.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));
	}

}

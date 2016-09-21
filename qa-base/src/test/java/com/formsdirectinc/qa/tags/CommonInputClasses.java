package com.formsdirectinc.qa.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.qa.pages.WizardPage;

/**
 * CommonInputClasses: CommonInputClasses for Name , Address,SSN ,ARN
 * 
 * @author:Orina
 */
public class CommonInputClasses extends WizardPage {

	private Name_FirstMiddleLast applicantName;
	private Numbers ssn, arn;
	private Address applicantAddress;
	private Country foreignAddress;

	String addAnotherExpression = "//a[contains(text(),'ADD ANOTHER')]";
	WebElement addAnotherField;

	public CommonInputClasses(WebDriver driver) {
		super(driver);

	}

	public CommonInputClasses addAnother() {

		addAnotherField = driver.findElement(By.xpath(addAnotherExpression));
		addAnotherField.click();
		return this;
	}

	public CommonInputClasses applicantNameDetails(String id, Properties data) {
		applicantName = new Name_FirstMiddleLast(driver, "applicationData", id);
		applicantName.setFirstNameField(data.getProperty("FirstName"));
		applicantName.setLastNameField(data.getProperty("LastName"));
		return this;
	}

	public CommonInputClasses applicantARNDetails(String id, Properties data) {

		arn = new Numbers(driver, id);
		arn.setAlienRegistrationNumber(data.getProperty("ARN"));
		return this;
	}

	public CommonInputClasses applicantSSNDetails(String id, Properties data) {

		ssn = new Numbers(driver, id);
		ssn.setSocialSecurityNumber(data.getProperty("SSN_1"),
				data.getProperty("SSN_2"), data.getProperty("SSN_3"));
		return this;
	}

	public CommonInputClasses applicantAddressDetails(String id, Properties data) {
		applicantAddress = new Address(driver, id);
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setState(data.getProperty("Mail_State"));
		applicantAddress.setZipcode(data.getProperty("Zipcode"));
		return this;
	}

	public CommonInputClasses applicantOtherAddressDetails(String id,
			Properties data) {
		applicantAddress = new Address(driver, id);
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setStateText(data.getProperty("State"));
		applicantAddress.setZipcode(data.getProperty("Zipcode"));
		return this;
	}

	public CommonInputClasses ForeignAddress(String id, Properties data) {
		applicantAddress = new Address(driver, id);
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setBirthState(data.getProperty("State"));
		applicantAddress.setZipcode(data.getProperty("Zipcode"));
		foreignAddress = new Country(driver, id);
		foreignAddress.setCountry(data.getProperty("Country"));

		return this;
	}

	public CommonInputClasses applicantNameDetails(String id, Properties data,
			String haveMiddleName) {
		applicantName = new Name_FirstMiddleLast(driver, "applicationData", id);
		applicantName.setFirstNameField(data.getProperty(id + ".first"));
		applicantName.setLastNameField(data.getProperty(id + ".last"));
		if (haveMiddleName.equalsIgnoreCase("yes")) {
			applicantName.setMiddleNameField(data.getProperty(id + ".middle"));
		} else {
			applicantName.setNoMiddleName();
		}
		return this;
	}

	public CommonInputClasses applicantNumberDetails(String id, Properties data) {

		PhoneNumber contactNumber = new PhoneNumber(driver, id);
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		return this;
	}
}

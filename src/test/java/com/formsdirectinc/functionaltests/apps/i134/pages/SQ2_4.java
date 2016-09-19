package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_4 extends WizardPage {
	private AdditionalInfoFields occupationName, employerName, businessType,
			businessName;
	private Address employerAddress, businessAddress, usEmployerAddress,
			usBusinessAddress, EmployercountrySelect, businessCountrySelect;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 OccupationAndEmployerName() {
		occupationName = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentDetails.occupation");
		occupationName.isStatusOther("Occupation Name");

		employerName = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentDetails.employerName");
		employerName.isStatusOther("Employer Name");
		return this;
	}

	public SQ2_4 BusinessTypeAndName(Properties data) {
		businessType = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentDetails.typeOfBusiness");
		businessType.isStatusOther(data.getProperty("I134_BusinessType"));

		businessName = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentDetails.nameOfBusiness");
		businessName.isStatusOther(data.getProperty("I134_BusinessName"));
		return this;
	}

	// VisaApplicant-Employed-NonUS
	public SQ2_4 NonUsEmployerAddress() {
		EmployercountrySelect = new Address(driver,
				"applicationData-applicant.employmentDetails.employerAddress.country");
		EmployercountrySelect.setCountryDropDown("Argentina");

		employerAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.employerAddress");// Employed-Visa
		employerAddress.setStreet("Street");
		employerAddress.setCity("City");
		employerAddress.setStateText("Texas");
		employerAddress.setZipcode("12345");
		return this;
	}

	// VisaApplicant-Employed-US
	public SQ2_4 UsEmployerAddress() {
		EmployercountrySelect = new Address(driver,
				"applicationData-applicant.employmentDetails.employerAddress.country");
		EmployercountrySelect.setCountryDropDown("United States of America");

		employerAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.employerAddress");// Employed-Visa
		employerAddress.setStreet("Street");
		employerAddress.setCity("City");
		employerAddress.setState("CA");
		employerAddress.setZipcode("12345");
		return this;
	}

	// VisaApplicant-Self-Employed-NonUS
	public SQ2_4 NonUsAddressOfBusiness() {
		businessCountrySelect = new Address(driver,
				"applicationData-applicant.employmentDetails.addressOfBusiness.country");
		businessCountrySelect.setCountryDropDown("Argentina");

		businessAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.addressOfBusiness");// Self-Employed-Visa
		businessAddress.setStreet("Street");
		businessAddress.setCity("City");
		businessAddress.setStateText("State");
		businessAddress.setZipcode("12345");
		return this;

	}

	// VisaApplicant-Self-Employed-US
	public SQ2_4 UsAddressOfBusiness() {
		businessCountrySelect = new Address(driver,
				"applicationData-applicant.employmentDetails.addressOfBusiness.country");
		businessCountrySelect.setCountryDropDown("United States of America");

		businessAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.addressOfBusiness");// Self-Employed-Visa
		businessAddress.setStreet("Street");
		businessAddress.setCity("City");
		businessAddress.setState("CA");
		businessAddress.setZipcode("12345");
		return this;
	}

	// Spouse-Employed
	public SQ2_4 USAddressOfEmployer(Properties data) {
		usEmployerAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.USAddressOfEmployer");// Employed-Spouse
		usEmployerAddress.setStreet(data.getProperty("I134_Street"));
		usEmployerAddress.setCity(data.getProperty("I134_City"));
		usEmployerAddress.setState(data.getProperty("I134_StateDD"));
		usEmployerAddress.setZipcode(data.getProperty("I134_ZipCode"));
		return this;
	}

	// Spouse-Self-Employed
	public SQ2_4 USAddressOfBusiness() {
		usBusinessAddress = new Address(driver,
				"applicationData-applicant.employmentDetails.USAddressOfBusiness");// Self-Employed-Spouse
		usBusinessAddress.setStreet("Street");
		usBusinessAddress.setCity("City");
		usBusinessAddress.setState("CA");
		usBusinessAddress.setZipcode("12345");
		return this;
	}

}
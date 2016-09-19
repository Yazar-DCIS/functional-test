package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ5_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_8 extends WizardPage {

	protected Name_FirstMiddleLast spouseNameTag;
	protected DateTag spouseDOB, dateOfMarriage;
	protected Address spouseBirthCountry, spouseCitizenshipCountry,
			homeAddress, placeOfMarriage;
	protected MultiRadioOptions immigrationStatus;
	protected AdditionalInfoFields otherStatus;
	protected Country spouseCountry;

	public SQ5_8(WebDriver driver) {
		super(driver);

	}

	public SQ5_8 spouseOfFatherInfo(Properties data, String status,
			String birthCountry) {

		if (!status.equalsIgnoreCase("NA")) {

			spouseNameTag = new Name_FirstMiddleLast(driver, "applicationData",
					"applicant.fatherInfo.maritalStatus.spouseDetails.name");
			spouseNameTag.setFirstNameField(data.getProperty("FirstName"));
			spouseNameTag.setMiddleNameField(data.getProperty("MiddleName"));
			spouseNameTag.setLastNameField(data.getProperty("LastName"));

			spouseDOB = new DateTag(driver,
					"applicant.fatherInfo.maritalStatus.spouseDetails.dateOfBirth");
			spouseDOB.selectDate(data.getProperty("DOB"));

			spouseBirthCountry = new Address(
					driver,

					"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.countryOfBirth");
			spouseBirthCountry.setCountry(data.getProperty("Country"));

			spouseCitizenshipCountry = new Address(driver,
					"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.nationality");
			spouseCitizenshipCountry.setCountry(data.getProperty("Country"));

			setHomeAdress(data, birthCountry);
			setDateOfMarriage(data);
			setPlaceOfMarriage(data);
			setImmigrationStatus_Citizen(data, status);
			saveScreenShot("n600", "SQ5_8"); clickContinueInSQ();
		}
		return this;

	}

	public SQ5_8 setHomeAdress(Properties data, String birthCountry) {

		spouseCountry = new Country(driver,
				"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.homeAddress");

		if (birthCountry.equalsIgnoreCase("isUS")) {
			homeAddress.setCountry(data.getProperty("DACA_Country"));
		}
		else if (birthCountry.equalsIgnoreCase("notUS")) {
			homeAddress.setCountry(data.getProperty("Country"));
		}
		saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		homeAddress = new Address(driver,
				"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.homeAddress");
		if (birthCountry.equalsIgnoreCase("isUS")) {
			homeAddress.setState(data.getProperty("State"));
		}
		homeAddress.setStreet(data.getProperty("StreetName"));
		homeAddress.setCity(data.getProperty("City"));
		homeAddress.setZipcode(data.getProperty("Zipcode"));
		return this;
	}

	public SQ5_8 setDateOfMarriage(Properties data) {

		dateOfMarriage = new DateTag(driver,
				"applicant.fatherInfo.maritalStatus.spouseDetails.dateOfMarriage");
		dateOfMarriage.selectDate(data.getProperty("toDate"));
		return this;
	}

	public SQ5_8 setPlaceOfMarriage(Properties data) {

		spouseCountry = new Country(
				driver,

				"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.placeOfMarriage");
		spouseCountry.setCountry(data.getProperty("DACA_Country"));

		placeOfMarriage = new Address(
				driver,

				"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.placeOfMarriage");
		placeOfMarriage.setCity(data.getProperty("City"));
		placeOfMarriage.setState(data.getProperty("State"));
		return this;
	}

	public SQ5_8 setImmigrationStatus_Citizen(Properties data, String status) {
		immigrationStatus = new MultiRadioOptions(
				driver,

				"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.immigrationStatus");

		if (status.equalsIgnoreCase("USCitizen")) {
			immigrationStatus.selectOption(1);
		}

		else if (status.equalsIgnoreCase("PermanentResident")) {
			immigrationStatus.selectOption(2);
		}

		else if (status.equalsIgnoreCase("Other")) {
			immigrationStatus.selectOption(3);
			otherStatus = new AdditionalInfoFields(
					driver,

					"applicationData-applicant.fatherInfo.maritalStatus.spouseDetails.otherImmigrationStatus");
			otherStatus.isStatusOther("explain");
		}

		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1 extends WizardPage {
	private Name_FirstMiddleLast name;
	private Gender gender;
	private DateTag dob;
	private Address countryOfCitizenship, countrySelect, currentAddress;
	private MaritalInfo maritalStatus = new MaritalInfo(driver,
			"applicationData-beneficiary.maritalStatus");
	private AdditionalInfoFields relationShip;
	private YesNo dependentForSupport;
	private MultiRadioOptions financialObligations;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 BeneficiaryBasicDetails(Properties data) {
		name = new Name_FirstMiddleLast(driver, "applicationData",
				"beneficiary.name");
		name.setFirstNameField(data.getProperty("FirstName"));
		name.setMiddleNameField(data.getProperty("MiddleName"));
		name.setLastNameField(data.getProperty("LastName"));

		dob = new DateTag(driver, "beneficiary.date");
		dob.selectMonth(data.getProperty("DOB_Month"));
		dob.selectDay(data.getProperty("DOB_Day"));
		dob.selectYear(data.getProperty("DOB_Year"));

		countryOfCitizenship = new Address(driver,
				"applicationData-beneficiary.countryOfCitizenship");
		countryOfCitizenship.setCountryDropDown(data
				.getProperty("I134_Country"));

		relationShip = new AdditionalInfoFields(driver,
				"applicationData-beneficiary.relationship");
		relationShip.isStatusOther(data.getProperty("I134_Relation"));

		return this;
	}

	public SQ3_1 selectMale() {
		gender = new Gender(driver, "applicationData-beneficiary.gender");
		gender.setGenderAsMale();
		return this;
	}

	public SQ3_1 selectFemale() {
		gender = new Gender(driver, "applicationData-beneficiary.gender");
		gender.setGenderAsFemale();
		return this;
	}

	public SQ3_1 setMaritalStatusSingle() {
		
		maritalStatus.setMarriageStatus("SINGLE");
		return this;
	}

	public SQ3_1 setMaritalStatusCurrentlyMarried() {
		
		maritalStatus.setMarriageStatus("Currently Married");
		return this;
	}

	public SQ3_1 setMaritalStatusWidowed() {
		
		maritalStatus.setMarriageStatus("Widowed");
		return this;
	}

	public SQ3_1 setMaritalStatusDivorced() {
		
		maritalStatus.setMarriageStatus("Divorced");
		return this;
	}

	public SQ3_1 BeneficiaryNonUsAddress() {
		currentAddress = new Address(driver,
				"applicationData-beneficiary.currentAddress");
		countrySelect = new Address(driver,
				"applicationData-beneficiary.currentAddress.country");
		countrySelect.setCountryDropDown("Argentina");
		currentAddress.setStreet("Street");
		currentAddress.setCity("City");
		currentAddress.setStateText("State");
		currentAddress.setZipcode("12345");
		return this;
	}

	public SQ3_1 BeneficiaryUsAddress(Properties data) {
		currentAddress = new Address(driver,
				"applicationData-beneficiary.currentAddress");
		countrySelect = new Address(driver,
				"applicationData-beneficiary.currentAddress.country");
		countrySelect.setCountryDropDown(data.getProperty("I134_USA"));
		currentAddress.setStreet(data.getProperty("I134_Street"));
		currentAddress.setCity(data.getProperty("I134_City"));
		currentAddress.setState(data.getProperty("I134_StateDD"));
		currentAddress.setZipcode(data.getProperty("I134_ZipCode"));
		return this;
	}

	public SQ3_1 YesDependent() {
		dependentForSupport = new YesNo(driver, "beneficiary.dependentOnYou");
		dependentForSupport.yes();
		return this;
	}

	public SQ3_1 NotDependent() {
		dependentForSupport = new YesNo(driver, "beneficiary.dependentOnYou");
		dependentForSupport.no();
		return this;
	}

	public SQ3_1 WholeFinancialObligations() {
		financialObligations = new MultiRadioOptions(driver,
				"applicationData-beneficiary.financialObligations");
		financialObligations.selectOption(1);
		return this;
	}

	public SQ3_1 PartialFinancialObligations() {
		financialObligations = new MultiRadioOptions(driver,
				"applicationData-beneficiary.financialObligations");
		financialObligations.selectOption(2);
		return this;
	}

}

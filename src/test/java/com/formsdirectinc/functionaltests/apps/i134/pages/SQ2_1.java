package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private Name_FirstMiddleLast name;
	private Gender gender = new Gender(driver, "applicationData-applicant.sex");
	private DateTag dob;
	private Address pobCity, pobCountryDD, pobStateText;
	private MaritalInfo maritalStatus= new MaritalInfo(driver,
			"applicationData-applicant.maritalStatus");

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 basicDetails(Properties data) {
		name = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		name.setFirstNameField(data.getProperty("FirstName"));
		name.setMiddleNameField(data.getProperty("MiddleName"));
		name.setLastNameField(data.getProperty("LastName"));

		dob = new DateTag(driver, "applicant.birth.dateOfBirth");
		dob.selectMonth(data.getProperty("DOB_Month"));
		dob.selectDay(data.getProperty("DOB_Day"));
		dob.selectYear(data.getProperty("DOB_Year"));

		pobCity = new Address(driver, "applicationData-applicant.placeOfBirth");
		pobCity.setCity("City");
		
		maritalStatus.setMarriageStatus("SINGLE");
		
		gender.setGenderAsFemale();
		
		pobCountryDD = new Address(driver,
				"applicationData-applicant.placeOfBirth.country");
		pobCountryDD.setCountryDropDown(data.getProperty("I134_Country"));

		pobStateText = new Address(driver,
				"applicationData-applicant.placeOfBirth");
		pobStateText.setStateText(data.getProperty("I134_State"));
		return this;
	}

	
}

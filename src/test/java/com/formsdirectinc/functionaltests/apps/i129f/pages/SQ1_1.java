package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast name;
	private YesNo havMaidenName;
	private Gender gender;
	private DateTag dob;
	private Address pobCountryDD, pobStateDD, pobStateText;
	private AdditionalInfoFields pobCity;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 petitionerInformation(Properties data, String maidenName,
			int count, String country) {
		name = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		name.setFirstNameField(data.getProperty("FirstName0"));
		name.setMiddleNameField(data.getProperty("MiddleName0"));
		name.setLastNameField(data.getProperty("LastName0"));

		havMaidenName = new YesNo(driver, "applicant.usedOtherNames");
		if (maidenName.equalsIgnoreCase("Yes")) {
			havMaidenName.yes();
			for (int i = 0; i < count; i++) {
				name = new Name_FirstMiddleLast(driver, "applicationData",
						"applicant.usedOtherNamesHistory[" + i
								+ "].usedOtherNames");
				name.setFirstNameField(data.getProperty("FirstName1"));
				name.setMiddleNameField(data.getProperty("MiddleName1"));
				name.setLastNameField(data.getProperty("LastName1"));
				if (i < count - 1) {
					CommonInputClasses name = new CommonInputClasses(driver);
					name.addAnother();

				}
			}
		}
		else if (maidenName.equalsIgnoreCase("No")) {
			havMaidenName.no();
		}

		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGenderAsFemale();

		dob = new DateTag(driver, "applicant.birth.dateOfBirth");
		dob.selectMonth(data.getProperty("DOB_Month"));
		dob.selectDay(data.getProperty("DOB_Day"));
		dob.selectYear(data.getProperty("DOB_Year"));

		if (country.equalsIgnoreCase("USA")) {
			pobCountryDD = new Address(driver,
					"applicationData-applicant.placeOfBirth.country");
			pobCountryDD.setCountryDropDown(data.getProperty("I134_USA"));

			pobStateDD = new Address(driver,
					"applicationData-applicant.placeOfBirth");
			pobStateDD.setState(data.getProperty("I134_StateDD"));
		}
		else if (country.equalsIgnoreCase("outSideUSA")) {
			pobCountryDD = new Address(driver,
					"applicationData-applicant.placeOfBirth.country");
			pobCountryDD.setCountryDropDown(data.getProperty("I134_Country"));

			pobStateText = new Address(driver,
					"applicationData-applicant.placeOfBirth");
			pobStateText.setStateText(data.getProperty("I134_State"));
		}

		pobCity = new AdditionalInfoFields(driver,
				"applicationData-applicant.placeOfBirth-city");
		pobCity.normalText(data.getProperty("City"));

		saveScreenShot("i129f", "SQ1_1"); clickContinueInSQ();
		return this;
	}
}

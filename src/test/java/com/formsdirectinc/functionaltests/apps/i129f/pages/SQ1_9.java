package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_9 extends WizardPage {

	private Name_FirstMiddleLast fatherName, motherName;
	private YesNo fatherStillAlive, motherStillAlive;
	private AdditionalInfoFields fatherResidence, motherResidence;
	private DateTag dateOfBirth;

	public SQ1_9(WebDriver driver) {
		super(driver);

	}

	public SQ1_9 parentsInformation(Properties data, String fatherAlive,
			String motherAlive) {
		// Father Details
		fatherName = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.fatherDetails.parentName");
		fatherName.setFirstNameField(data.getProperty("FatherName"));
		fatherName.setLastNameField(data.getProperty("FatherLName"));

		dateOfBirth = new DateTag(driver, "applicant.fatherDetails.dob");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("I130_DOB_Year"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-applicant.fatherDetails.birthTown");
		fatherResidence.normalText(data.getProperty("City"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-applicant.fatherDetails.birthCountry-country");
		fatherResidence.selectDDM(data.getProperty("Country"));

		fatherStillAlive = new YesNo(driver, "applicant.fatherDetails.alive");
		if (fatherAlive.equalsIgnoreCase("Yes")) {
			fatherStillAlive.yes();

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-applicant.fatherDetails.cityOfResidence");
			fatherResidence.normalText(data.getProperty("City"));

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-applicant.fatherDetails.countryOfResidence-country");
			fatherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (fatherAlive.equalsIgnoreCase("No")) {
			fatherStillAlive.no();
		}

		// MotherDetails
		motherName = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.motherDetails.parentName");
		motherName.setFirstNameField(data.getProperty("MotherName"));
		motherName.setLastNameField(data.getProperty("Mother_LName"));

		dateOfBirth = new DateTag(driver, "applicant.motherDetails.dob");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("year"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-applicant.motherDetails.birthTown");
		motherResidence.normalText(data.getProperty("City"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-applicant.motherDetails.birthCountry-country");
		motherResidence.selectDDM(data.getProperty("Country"));

		motherStillAlive = new YesNo(driver, "applicant.motherDetails.alive");
		if (motherAlive.equalsIgnoreCase("Yes")) {
			motherStillAlive.yes();

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-applicant.motherDetails.cityOfResidence");
			motherResidence.normalText(data.getProperty("City"));

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-applicant.motherDetails.countryOfResidence-country");
			motherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (motherAlive.equalsIgnoreCase("No")) {
			motherStillAlive.no();
		}
		saveScreenShot("i129f", "SQ1_9"); clickContinueInSQ();
		return this;
	}
}
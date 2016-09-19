package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_8 extends WizardPage {

	private Name_FirstMiddleLast fatherName, motherName;
	private YesNo fatherStillAlive, motherStillAlive;
	private AdditionalInfoFields fatherResidence, motherResidence;
	private DateTag dateOfBirth;

	public SQ2_8(WebDriver driver) {
		super(driver);
	}

	public SQ2_8 fianceParentsInformation(Properties data, String fatherAlive,
			String motherAlive) {
		// Father Details
		fatherName = new Name_FirstMiddleLast(driver, "applicationData",
				"foreignFiance.fatherDetails.parentName");
		fatherName.setFirstNameField(data.getProperty("FatherName"));
		fatherName.setLastNameField(data.getProperty("FatherLName"));

		dateOfBirth = new DateTag(driver, "foreignFiance.fatherDetails.dob");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("I130_DOB_Year"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-foreignFiance.fatherDetails.birthTown");
		fatherResidence.normalText(data.getProperty("City"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-foreignFiance.fatherDetails.birthCountry-country");
		fatherResidence.selectDDM(data.getProperty("Country"));

		fatherStillAlive = new YesNo(driver,
				"foreignFiance.fatherDetails.alive");
		if (fatherAlive.equalsIgnoreCase("Yes")) {
			fatherStillAlive.yes();

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-foreignFiance.fatherDetails.cityOfResidence");
			fatherResidence.normalText(data.getProperty("City"));

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-foreignFiance.fatherDetails.countryOfResidence-country");
			fatherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (fatherAlive.equalsIgnoreCase("No")) {
			fatherStillAlive.no();
		}

		// MotherDetails
		motherName = new Name_FirstMiddleLast(driver, "applicationData",
				"foreignFiance.motherDetails.parentName");
		motherName.setFirstNameField(data.getProperty("MotherName"));
		motherName.setLastNameField(data.getProperty("Mother_LName"));

		dateOfBirth = new DateTag(driver, "foreignFiance.motherDetails.dob");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("year"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-foreignFiance.motherDetails.birthTown");
		motherResidence.normalText(data.getProperty("City"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-foreignFiance.motherDetails.birthCountry-country");
		motherResidence.selectDDM(data.getProperty("Country"));

		motherStillAlive = new YesNo(driver,
				"foreignFiance.motherDetails.alive");
		if (motherAlive.equalsIgnoreCase("Yes")) {
			motherStillAlive.yes();

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-foreignFiance.motherDetails.cityOfResidence");
			motherResidence.normalText(data.getProperty("City"));

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-foreignFiance.motherDetails.countryOfResidence-country");
			motherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (motherAlive.equalsIgnoreCase("No")) {
			motherStillAlive.no();
		}
		saveScreenShot("i129f", "SQ2_8"); clickContinueInSQ();
		return this;
	}
}
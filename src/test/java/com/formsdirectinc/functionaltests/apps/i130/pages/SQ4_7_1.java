package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_7_1 extends WizardPage {

	private Name_FirstMiddleLast fatherName, motherName;
	private YesNo fatherStillAlive, motherStillAlive;
	private AdditionalInfoFields fatherResidence, motherResidence;
	private DateTag dateOfBirth;

	public SQ4_7_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_7_1 spouseParentsInformation(Properties data,
			String fatherAlive, String motherAlive) {

		if (!fatherAlive.equalsIgnoreCase("na")
				&& !motherAlive.equalsIgnoreCase("na")) {

			set_FatherName(data);
			set_FatherDateOfBirth(data);
			setFatherPlaceOfResidence(data, fatherAlive);

			set_MotherName(data);
			set_MotherDateOfBirth(data);
			setMotherPlaceOfResidence(data, motherAlive);

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void set_FatherName(Properties data) {
		fatherName = new Name_FirstMiddleLast(driver, "applicationData",
				"spouseInfo.fatherName");
		fatherName.setFirstNameField(data.getProperty("FatherName"));
		fatherName.setLastNameField(data.getProperty("FatherLName"));

	}

	public void set_FatherDateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "spouseInfo.fatherDOB.dateOfBirth");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("I130_DOB_Year"));

	}

	public void setFatherPlaceOfResidence(Properties data, String fatherAlive) {

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.fatherPlaceOfBirth");
		fatherResidence.normalText(data.getProperty("City"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.fatherCountryOfBirth-country");
		fatherResidence.selectDDM(data.getProperty("Country"));

		fatherStillAlive = new YesNo(driver, "spouseInfo.fatherStillAlive");
		if (fatherAlive.equalsIgnoreCase("Yes")) {
			fatherStillAlive.yes();

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-spouseInfo.fatherCityOfResidence");

			fatherResidence.normalText(data.getProperty("City"));

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-spouseInfo.fatherCountryOfResidence-country");

			fatherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (fatherAlive.equalsIgnoreCase("No")) {
			fatherStillAlive.no();
		}

	}

	public void set_MotherName(Properties data) {
		motherName = new Name_FirstMiddleLast(driver, "applicationData",
				"spouseInfo.motherName");
		motherName.setFirstNameField(data.getProperty("MotherName"));
		motherName.setLastNameField(data.getProperty("Mother_LName"));

	}

	public void set_MotherDateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "spouseInfo.motherDOB.dateOfBirth");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("year"));

	}

	public void setMotherPlaceOfResidence(Properties data, String motherAlive) {

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.motherPlaceOfBirth");
		motherResidence.normalText(data.getProperty("City"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.motherCountryOfBirth-country");
		motherResidence.selectDDM(data.getProperty("Country"));

		motherStillAlive = new YesNo(driver, "spouseInfo.motherStillAlive");
		if (motherAlive.equalsIgnoreCase("Yes")) {
			motherStillAlive.yes();

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-spouseInfo.motherCityOfResidence");

			motherResidence.normalText(data.getProperty("City"));

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-spouseInfo.motherCountryOfResidence-country");

			motherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (motherAlive.equalsIgnoreCase("No")) {
			motherStillAlive.no();
		}

	}

}

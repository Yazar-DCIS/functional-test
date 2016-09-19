package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {

	private Name_FirstMiddleLast fatherName, motherName;
	private YesNo fatherStillAlive, motherStillAlive;
	private AdditionalInfoFields fatherResidence, motherResidence;
	private DateTag dateOfBirth;

	public SQ3_3(WebDriver driver) {
		super(driver);

	}

	public SQ3_3 applicantParentsInformation(Properties data,
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
				"otherInfo.fatherName");
		fatherName.setFirstNameField(data.getProperty("FatherName"));
		fatherName.setLastNameField(data.getProperty("FatherLName"));

	}

	public void set_FatherDateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "otherInfo.fatherDOB.dateOfBirth");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("I130_DOB_Year"));

	}

	public void setFatherPlaceOfResidence(Properties data, String fatherAlive) {

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-otherInfo.fatherPlaceOfBirth");
		fatherResidence.normalText(data.getProperty("City"));

		fatherResidence = new AdditionalInfoFields(driver,
				"applicationData-otherInfo.fatherCountryOfBirth-country");
		fatherResidence.selectDDM(data.getProperty("Country"));

		fatherStillAlive = new YesNo(driver, "otherInfo.fatherStillAlive");
		if (fatherAlive.equalsIgnoreCase("Yes")) {
			fatherStillAlive.yes();

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-otherInfo.fatherCityOfResidence");

			fatherResidence.normalText(data.getProperty("City"));

			fatherResidence = new AdditionalInfoFields(driver,

			"applicationData-otherInfo.fatherCountryOfResidence-country");

			fatherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (fatherAlive.equalsIgnoreCase("No")) {
			fatherStillAlive.no();
		}

	}

	public void set_MotherName(Properties data) {
		motherName = new Name_FirstMiddleLast(driver, "applicationData",
				"otherInfo.motherName");
		motherName.setFirstNameField(data.getProperty("MotherName"));
		motherName.setLastNameField(data.getProperty("Mother_LName"));

	}

	public void set_MotherDateOfBirth(Properties data) {
		dateOfBirth = new DateTag(driver, "otherInfo.motherDOB.dateOfBirth");
		dateOfBirth.selectMonth(data.getProperty("month"));
		dateOfBirth.selectDay(data.getProperty("DOB_Day"));
		dateOfBirth.selectYear(data.getProperty("year"));

	}

	public void setMotherPlaceOfResidence(Properties data, String motherAlive) {

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-otherInfo.motherPlaceOfBirth");
		motherResidence.normalText(data.getProperty("City"));

		motherResidence = new AdditionalInfoFields(driver,
				"applicationData-otherInfo.motherCountryOfBirth-country");
		motherResidence.selectDDM(data.getProperty("Country"));

		motherStillAlive = new YesNo(driver, "otherInfo.motherStillAlive");
		if (motherAlive.equalsIgnoreCase("Yes")) {
			motherStillAlive.yes();

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-otherInfo.motherCityOfResidence");

			motherResidence.normalText(data.getProperty("City"));

			motherResidence = new AdditionalInfoFields(driver,

			"applicationData-otherInfo.motherCountryOfResidence-country");

			motherResidence.selectDDM(data.getProperty("Country"));
		}

		else if (motherAlive.equalsIgnoreCase("No")) {
			motherStillAlive.no();
		}

	}

}

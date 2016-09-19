package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1 extends WizardPage {

	protected Name_FirstMiddleLast fatherNameTag;
	protected DateTag fatherDOB;
	protected Address fatherBirthCountry, fatherCitizenshipCountry;

	public SQ5_1(WebDriver driver) {
		super(driver);

	}

	public SQ5_1 fatherBiographicalInfo(Properties data, String birthCountry) {

		if (!birthCountry.equalsIgnoreCase("NA")) {

			fatherNameTag = new Name_FirstMiddleLast(driver, "applicationData",
					"applicant.fatherInfo.name");
			fatherNameTag.setFirstNameField(data.getProperty("FirstName"));
			fatherNameTag.setMiddleNameField(data.getProperty("MiddleName"));
			fatherNameTag.setLastNameField(data.getProperty("LastName"));

			fatherDOB = new DateTag(driver, "applicant.fatherInfo.dateOfBirth");
			fatherDOB.selectDateAsSingle(data.getProperty("DateOfBirth"));

			fatherBirthCountry = new Address(driver,
					"applicationData-applicant.fatherInfo.country");
			if (birthCountry.equalsIgnoreCase("isUS")) {
				fatherBirthCountry.setCountry(data.getProperty("DACA_Country"));
			}
			else if (birthCountry.equalsIgnoreCase("notUS")) {
				fatherBirthCountry.setCountry(data.getProperty("Country"));
			}

			fatherCitizenshipCountry = new Address(driver,
					"applicationData-applicant.fatherInfo.nationality");
			fatherCitizenshipCountry.setCountry(data.getProperty("Country"));
			saveScreenShot("n600", "SQ5_1"); clickContinueInSQ();
		}
		return this;

	}

}

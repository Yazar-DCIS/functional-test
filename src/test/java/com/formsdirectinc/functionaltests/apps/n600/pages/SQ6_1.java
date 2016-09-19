package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_1 extends WizardPage {

	protected Name_FirstMiddleLast motherNameTag;
	protected DateTag motherDOB;
	protected Address motherBirthCountry, motherCitizenshipCountry;

	public SQ6_1(WebDriver driver) {
		super(driver);

	}

	public SQ6_1 motherBiographicalInfo(Properties data, String birthCountry) {
		if (!birthCountry.equalsIgnoreCase("NA")) {

			motherNameTag = new Name_FirstMiddleLast(driver, "applicationData",
					"applicant.motherInfo.name");
			motherNameTag.setFirstNameField(data.getProperty("FirstName"));
			motherNameTag.setMiddleNameField(data.getProperty("MiddleName"));
			motherNameTag.setLastNameField(data.getProperty("LastName"));

			motherDOB = new DateTag(driver, "applicant.motherInfo.dateOfBirth");
			motherDOB.selectDate(data.getProperty("DOB"));

			motherBirthCountry = new Address(driver,
					"applicationData-applicant.motherInfo.country");
			if (birthCountry.equalsIgnoreCase("isUS")) {
				motherBirthCountry.setCountry(data.getProperty("DACA_Country"));
			}
			else if (birthCountry.equalsIgnoreCase("notUS")) {
				motherBirthCountry.setCountry(data.getProperty("Country"));
			}

			motherCitizenshipCountry = new Address(driver,
					"applicationData-applicant.motherInfo.nationality");
			motherCitizenshipCountry.setCountry(data.getProperty("Country"));
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();

		}
		return this;

	}

}

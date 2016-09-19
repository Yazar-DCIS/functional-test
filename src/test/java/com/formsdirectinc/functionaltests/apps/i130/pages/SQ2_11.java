package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_11 extends WizardPage {

	private Country relativeCountry;
	private Name_FirstMiddleLast relativeName;
	private DateTag relativeDOB;

	public SQ2_11(WebDriver driver) {
		super(driver);

	}

	public SQ2_11 relativeSpouseInfo(Properties data, String visitPage) {
		if (visitPage.equalsIgnoreCase("yes")) {
			relativeName = new Name_FirstMiddleLast(driver, "applicationData",
					"relative.spouseDetails.name");
			relativeName.setFirstNameField(data.getProperty("FirstName1"));
			relativeName.setLastNameField(data.getProperty("LastName"));

			relativeDOB = new DateTag(driver,
					"relative.spouseDetails.birthDate.dateOfBirth");
			relativeDOB.selectDate(data.getProperty("DOB"));

			relativeCountry = new Country(driver,
					"applicationData-relative.spouseDetails.birthCountry.countryOfBirth");
			relativeCountry.setCountryDDM(data.getProperty("Country"));

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

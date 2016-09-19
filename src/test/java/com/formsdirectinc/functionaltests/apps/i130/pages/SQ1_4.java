package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_4 extends WizardPage {

	private Address place_Born;
	private DateTag place_Born_date;

	public SQ1_4(WebDriver driver) {
		super(driver);

	}

	public SQ1_4 applicantDateAndPlaceOfBirth(Properties data,
			String answerForAge, String answerForCountry) {

		if (!answerForAge.equalsIgnoreCase("na")
				&& !answerForCountry.equalsIgnoreCase("na")) {

			place_Born_date = new DateTag(driver, "applicant.birth.dateOfBirth");

			if (answerForAge.equalsIgnoreCase("ageAbove18")) {
				place_Born_date.selectDate(data.getProperty("ageAbove18"));
			} else if (answerForAge.equalsIgnoreCase("ageBelow18")) {
				place_Born_date.selectDate(data.getProperty("ageBelow18"));
			}

			place_Born = new Address(driver,
					"applicationData-applicant.placeOfBirth.country");

			if (answerForCountry.equalsIgnoreCase("insideUS")) {
				place_Born.setCountryDropDown(data.getProperty("DACA_Country"));
			} else if (answerForCountry.equalsIgnoreCase("outsideUS")) {
				place_Born.setCountryDropDown(data.getProperty("Country"));
			}

			place_Born = new Address(driver,
					"applicationData-applicant.placeOfBirth");

			place_Born.setCity(data.getProperty("City"));

			if (answerForCountry.equalsIgnoreCase("insideUS")) {
				place_Born.setState(data.getProperty("tripState"));
			} else if (answerForCountry.equalsIgnoreCase("outsideUS")) {
				place_Born.setStateText(data.getProperty("State"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

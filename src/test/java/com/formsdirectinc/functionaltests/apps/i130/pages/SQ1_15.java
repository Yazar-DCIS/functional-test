package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_15 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_15 extends WizardPage {

	private DateTag dateOfMarriage;
	private Address placeOfMarriage;

	public SQ1_15(WebDriver driver) {
		super(driver);

	}

	public SQ1_15 applicantDateAndPlaceOfMarriage(Properties data,
			String answerForCountry) {

		if (!answerForCountry.equalsIgnoreCase("na")) {

			dateOfMarriage = new DateTag(driver, "applicant.dateOfMarriage");
			dateOfMarriage.selectDate(data.getProperty("fromDate"));

			placeOfMarriage = new Address(driver,
					"applicationData-applicant.placeOfMarriage.country");

			if (answerForCountry.equalsIgnoreCase("insideUS")) {
				placeOfMarriage.setCountryDropDown(data
						.getProperty("DACA_Country"));
			}
			else if (answerForCountry.equalsIgnoreCase("outsideUS")) {
				placeOfMarriage.setCountryDropDown(data.getProperty("Country"));
			}

			placeOfMarriage = new Address(driver,
					"applicationData-applicant.placeOfMarriage");
			placeOfMarriage.setCity(data.getProperty("City"));

			if (answerForCountry.equalsIgnoreCase("insideUS")) {
				placeOfMarriage.setState(data.getProperty("tripState"));
			}
			else if (answerForCountry.equalsIgnoreCase("outsideUS")) {
				placeOfMarriage.setStateText(data.getProperty("State"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

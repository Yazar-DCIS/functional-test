package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_10 extends WizardPage {

	private DateTag dateOfMarriage;
	private Address placeOfMarriage;

	public SQ2_10(WebDriver driver) {
		super(driver);

	}

	public SQ2_10 relativeDateAndPlaceOfMarriage(Properties data, String country) {

		if (!country.equalsIgnoreCase("na")) {

			dateOfMarriage = new DateTag(driver, "relative.dateOfMarriage");
			dateOfMarriage.selectDate(data.getProperty("fromDate"));

			placeOfMarriage = new Address(driver,
					"applicationData-relative.placeOfMarriage.country");

			if (country.equalsIgnoreCase("insideUS")) {
				placeOfMarriage.setCountryDropDown(data
						.getProperty("DACA_Country"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				placeOfMarriage.setCountryDropDown(data.getProperty("Country"));
			}

			placeOfMarriage = new Address(driver,
					"applicationData-relative.placeOfMarriage");
			placeOfMarriage.setCity(data.getProperty("City"));

			if (country.equalsIgnoreCase("insideUS")) {
				placeOfMarriage.setState(data.getProperty("tripState"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				placeOfMarriage.setStateText(data.getProperty("State"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

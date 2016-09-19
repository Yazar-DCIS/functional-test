package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_7 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_7 extends WizardPage {

	private Address place_Born;
	private DateTag place_Born_date;

	public SQ4_7(WebDriver driver) {
		super(driver);

	}

	public SQ4_7 spouseDateAndPlaceOfBirth(Properties data, String country) {

		if (!country.equalsIgnoreCase("na")) {

			place_Born_date = new DateTag(driver,
					"spouseInfo.birthDate.dateOfBirth");

			place_Born_date.selectDate(data.getProperty("ageAbove18"));

			place_Born = new Address(driver,
					"applicationData-spouseInfo.placeOfBirth.country");

			if (country.equalsIgnoreCase("insideUS")) {
				place_Born.setCountryDropDown(data.getProperty("DACA_Country"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				place_Born.setCountryDropDown(data.getProperty("Country"));
			}

			place_Born = new Address(driver,
					"applicationData-spouseInfo.placeOfBirth");

			place_Born.setCity(data.getProperty("City"));

			if (country.equalsIgnoreCase("insideUS")) {
				place_Born.setState(data.getProperty("tripState"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				place_Born.setStateText(data.getProperty("State"));
			}

			place_Born = new Address(driver,
					"applicationData-spouseInfo.countryOfCitizenship");
			place_Born.setCountryDropDown(data.getProperty("Country"));

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_2 extends WizardPage {

	private Address addressGA;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 addressOfGovtAgency(String agency_Address, Properties data) {
		if (!agency_Address.equalsIgnoreCase("NA")) {
			addressGA = new Address(driver,
					"applicationData-formSpecific.addressOfGovtAgency");
			addressGA.setStreet(data.getProperty("StreetName"));
			addressGA.setCity(data.getProperty("City"));
			addressGA.setRandomState(data.getProperty("State"));
			addressGA.setZipcode(data.getProperty("Zipcode"));
			addressGA.setCountryField(data.getProperty("Place"));
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

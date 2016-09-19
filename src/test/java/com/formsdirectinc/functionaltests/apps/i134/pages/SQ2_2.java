package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2 extends WizardPage {
	private Address homeAddress, countrySelect;

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_2 NonUsHomeAddress(Properties data) {
		countrySelect = new Address(driver,
				"applicationData-applicant.homeAddress.country");
		countrySelect.setCountryDropDown(data.getProperty("I134_Country"));

		homeAddress = new Address(driver,
				"applicationData-applicant.homeAddress");
		homeAddress.setStreet(data.getProperty("I134_Street"));
		homeAddress.setCity(data.getProperty("I134_City"));
		homeAddress.setZipcode(data.getProperty("I134_ZipCode"));

		homeAddress = new Address(driver,
				"applicationData-applicant.homeAddress");
		homeAddress.setStateText(data.getProperty("I134_State"));
		return this;
	}

	
}

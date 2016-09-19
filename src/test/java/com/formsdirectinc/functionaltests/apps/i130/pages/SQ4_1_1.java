package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_1_1 extends WizardPage {

	private Address relativeAddress;

	public SQ4_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_1_1 spouseForeignAddress(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {

			relativeAddress = new Address(driver,
					"applicationData-spouseInfo.foriegnAddress");

			relativeAddress.setStreet(data.getProperty("StreetName"));

			relativeAddress.setCity(data.getProperty("City"));

			relativeAddress.setBirthState(data.getProperty("tripState"));

			relativeAddress.setZipcode(data.getProperty("Zipcode"));

			relativeAddress = new Address(driver,
					"applicationData-spouseInfo.foriegnAddress.country");

			relativeAddress.setCountryDropDown(data.getProperty("Country"));

			PhoneNumber relativeNumber = new PhoneNumber(driver,
					"applicationData-spouseInfo.phone");

			relativeNumber.setPhoneCode(data.getProperty("Phone1"));

			relativeNumber.setPhoneNumber(data.getProperty("Phone2"));
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();

		}
		return this;
	}

}

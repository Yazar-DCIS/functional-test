package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {

	private Address relativeAddress;

	public SQ2_6(WebDriver driver) {
		super(driver);

	}

	public SQ2_6 familyMemberForeignAddress(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			relativeAddress = new Address(driver,
					"applicationData-relative.foriegnAddress");

			relativeAddress.setStreet(data.getProperty("StreetName"));

			relativeAddress.setCity(data.getProperty("City"));

			relativeAddress.setBirthState(data.getProperty("tripState"));

			relativeAddress.setZipcode(data.getProperty("Zipcode"));

			relativeAddress = new Address(driver,
					"applicationData-relative.foriegnAddress.country");

			relativeAddress.setCountryDropDown(data.getProperty("Country"));

			PhoneNumber relativeNumber = new PhoneNumber(driver,
					"applicationData-relative.phone");

			relativeNumber.setPhoneCode(data.getProperty("Phone1"));

			relativeNumber.setPhoneNumber(data.getProperty("Phone2"));

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

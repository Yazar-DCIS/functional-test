package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6_1 extends WizardPage {

	private Address relativeAddress;

	public SQ2_6_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_6_1 familyMemberAddressInUS(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			relativeAddress = new Address(driver,
					"applicationData-relative.whereFamilyMemberWillLiveInUS");

			relativeAddress.setStreet(data.getProperty("StreetName"));

			relativeAddress.setCity(data.getProperty("City"));

			relativeAddress.setState(data.getProperty("State"));

			relativeAddress.setZipcode(data.getProperty("Zipcode"));

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

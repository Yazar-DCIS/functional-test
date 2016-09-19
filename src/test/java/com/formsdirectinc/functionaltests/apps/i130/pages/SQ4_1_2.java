package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1_2 extends WizardPage {

	public SQ4_1_2(WebDriver driver) {
		super(driver);

	}

	private Address usAddress;

	public SQ4_1_2 spouseUSAddress(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			usAddress = new Address(driver,
					"applicationData-spouseInfo.usAddress");
			usAddress.setStreet(data.getProperty("StreetName"));
			usAddress.setCity(data.getProperty("City"));
			usAddress.setState(data.getProperty("State"));
			usAddress.setZipcode(data.getProperty("Zipcode"));
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

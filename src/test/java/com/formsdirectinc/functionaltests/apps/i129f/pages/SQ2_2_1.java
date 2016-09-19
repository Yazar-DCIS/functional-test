package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_1 extends WizardPage {
	private Address pobCountry;
	private PhoneNumber cellNo;
	private AdditionalInfoFields pobCity;

	public SQ2_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_2_1 residences(Properties data, String visitPage) {
		if (visitPage.equalsIgnoreCase("yes")) {
			cellNo = new PhoneNumber(driver,
					"applicationData-foreignFiance.dayTimePhone");
			cellNo.setPhoneCode(data.getProperty("Phone1"));
			cellNo.setPhoneNumber(data.getProperty("Phone2"));

			pobCity = new AdditionalInfoFields(driver,
					"applicationData-foreignFiance.embassyVisaApplied.city");
			pobCity.normalText(data.getProperty("City"));

			pobCountry = new Address(driver,
					"applicationData-foreignFiance.embassyVisaApplied.country");
			pobCountry.setCountryDropDown(data.getProperty("I134_Country"));
			saveScreenShot("i129f", "SQ2_2_1"); clickContinueInSQ();
		}
		return this;
	}

}

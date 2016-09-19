package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_3 extends WizardPage {
	private Address country, visaApplyCountry,selectAddress;
	private AdditionalInfoFields visaApplyCity;
	private DateTag fromDate, toDate;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public SQ2_3 fianceResidencesAbroad(Properties data, String residenceAbroad) {
		if (!residenceAbroad.equalsIgnoreCase("NA")) {
			selectAddress = new Address(driver,
					"applicationData-foreignFiance.foreignAddress");
			selectAddress.setStreet(data.getProperty("StreetName"));
			selectAddress.setCity(data.getProperty("City"));
			selectAddress.setBirthState(data.getProperty("State"));
			selectAddress.setZipcode(data.getProperty("Zipcode"));

			country = new Address(driver,
					"applicationData-foreignFiance.foreignAddress.country");
			country.setCountryDropDown(data.getProperty("I134_Country"));

			fromDate = new DateTag(driver,
					"foreignFiance.datesAtAddress.fromDate");
			fromDate.selectDateAsSingle(data.getProperty("fromDate"));

			toDate = new DateTag(driver, "foreignFiance.datesAtAddress.toDate");
			toDate.selectDateAsSingle(data.getProperty("toDate"));

			PhoneNumber contactNumber = new PhoneNumber(driver,
					"applicationData-foreignFiance.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));

			visaApplyCity = new AdditionalInfoFields(driver,
					"applicationData-foreignFiance.embassyVisaWillBeApplied.city");
			visaApplyCity.normalText(data.getProperty("City"));

			visaApplyCountry = new Address(driver,
					"applicationData-foreignFiance.embassyVisaWillBeApplied.country");
			visaApplyCountry.setCountryDropDown(data
					.getProperty("I134_Country"));

			saveScreenShot("i129f", "SQ2_3"); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ5_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2_1 extends WizardPage {

	
	

	private Country spouseCountry;
	private Address spouseAddress;

	public SQ5_2_1(WebDriver driver) {
		super(driver);

	}

	public void addressOfSpouse(Properties data) {

		spouseCountry = new Country(driver,
				"applicationData-principalFamilyMembers.spouseInfo.address.country");
		spouseCountry.setCountryDDM(data.getProperty("Country"));

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		spouseAddress = new Address(driver,
				"applicationData-principalFamilyMembers.spouseInfo.address");
		spouseAddress.setStreet(data.getProperty("StreetName"));
		spouseAddress.setCity(data.getProperty("City"));

		PhoneNumber spouseNumber = new PhoneNumber(driver,
				"applicationData-principalFamilyMembers.spouseInfo.phoneNumber");
		spouseNumber.setPhoneCode(data.getProperty("Phone1"));
		spouseNumber.setPhoneNumber(data.getProperty("Phone2"));

	}

}

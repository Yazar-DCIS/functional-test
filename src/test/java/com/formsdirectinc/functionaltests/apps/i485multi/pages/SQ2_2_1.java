package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_1 extends WizardPage {

	
	

	private Address applicantAddress;
	private DateTag dateMovedFrom, dateMovedTo;

	public SQ2_2_1(WebDriver driver) {
		super(driver);

	}

	public void applicantAddressDetails(Properties data) {

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.addressInfo[0].address.country");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.addressInfo[0].address");
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));

		dateMovedFrom = new DateTag(driver,
				"principalApplicant.addressInfo[0].dateRange.fromDate");
		dateMovedFrom.selectDate(data.getProperty("fromDate"));

		dateMovedTo = new DateTag(driver,
				"principalApplicant.addressInfo[0].dateRange.toDate");
		dateMovedTo.selectDate(data.getProperty("toDate"));

	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ2_2_2 extends WizardPage {

	private Address foreignAddressFields, foreignCountry;
	private DateTag dateRangeF, dateRangeT;

	public SQ2_2_2(WebDriver driver) {
		super(driver);
	}

	public void setForeignAddress(Properties data) {
		foreignAddressFields = new Address(driver,
				"applicationData-applicant.lastLivedForeignAddress");
		foreignAddressFields.setStreet(data.getProperty("StreetName"));
		foreignAddressFields.setCity(data.getProperty("City"));
		foreignAddressFields.setBirthState(data.getProperty("State"));
		foreignAddressFields.setZipcode(data.getProperty("Zipcode"));
		foreignCountry = new Address(driver,
				"applicationData-applicant.lastLivedForeignAddress.country");
		foreignCountry.setCountry(data.getProperty("DOB_Country"));
	}

	public void fromDateAddress(Properties data) {
		dateRangeF = new DateTag(driver,
				"applicant.foreignAddressDateRange.fromDate");
		dateRangeF.selectMonth(data.getProperty("month"));
		dateRangeF.selectYear(data.getProperty("fromYear"));
	}

	public void toDateAddress(Properties data) {
		dateRangeT = new DateTag(driver,
				"applicant.foreignAddressDateRange.toDate");
		dateRangeT.selectMonth(data.getProperty("month"));
		dateRangeT.selectYear(data.getProperty("toYear"));
	}

}
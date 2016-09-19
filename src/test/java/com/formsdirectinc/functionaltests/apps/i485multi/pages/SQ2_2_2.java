package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_2_2 extends WizardPage {

	
	

	private Address applicantAddress;
	private DateTag dateMovedFrom, dateMovedTo;
	private YesNo beneficiaryAddress;

	public SQ2_2_2(WebDriver driver) {
		super(driver);

	}

	public void applicantForeignAddressDetails(Properties data) {

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.recentForeignAddressInfo.address.country");
		applicantAddress.setCountry(data.getProperty("Country"));

		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.recentForeignAddressInfo.address");
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));

		dateMovedFrom = new DateTag(driver,
				"principalApplicant.recentForeignAddressInfo.dateRange.fromDate");
		dateMovedFrom.selectMonth(data.getProperty("fromMonth"));
		dateMovedFrom.selectYear(data.getProperty("fromYear"));

		dateMovedTo = new DateTag(driver,
				"principalApplicant.recentForeignAddressInfo.dateRange.toDate");
		dateMovedTo.selectMonth(data.getProperty("toMonth"));
		dateMovedTo.selectYear(data.getProperty("toYear"));

	}

	public void beneficiaryForeignAddressDetails() {
		beneficiaryAddress = new YesNo(driver,
				"beneficiaryFormSpecific.livedOutsideUS");
		beneficiaryAddress.no();
	}

}

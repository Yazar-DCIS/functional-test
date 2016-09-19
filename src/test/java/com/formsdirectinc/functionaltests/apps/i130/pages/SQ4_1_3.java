package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1_3 extends WizardPage {

	private Address spouseInfo;

	private DateTag spouseInfoFrom_Date, spouseInfoTo_Date;

	public SQ4_1_3(WebDriver driver) {
		super(driver);

	}

	public SQ4_1_3 spouseResidenceOutsideUSInfo(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			spouseInfo = new Address(driver,
					"applicationData-spouseInfo.lostLivedForiegnAddress.country");
			spouseInfo.setCountryDropDown(data.getProperty("Country"));

			spouseInfo = new Address(driver,
					"applicationData-spouseInfo.lostLivedForiegnAddress");
			spouseInfo.setStreet(data.getProperty("StreetName"));

			spouseInfo.setCity(data.getProperty("City"));

			spouseInfo.setZipcode(data.getProperty("Zipcode"));

			spouseInfo.setBirthState(data.getProperty("tripState"));

			spouseInfoFrom_Date = new DateTag(driver,
					"spouseInfo.foriegnAddressDateRange.fromDate");
			spouseInfoFrom_Date.selectMonth(data.getProperty("month"));
			spouseInfoFrom_Date.selectYear(data.getProperty("fromYear"));

			spouseInfoTo_Date = new DateTag(driver,
					"spouseInfo.foriegnAddressDateRange.toDate");
			spouseInfoTo_Date.selectMonth(data.getProperty("toMonth"));
			spouseInfoTo_Date.selectYear(data.getProperty("toYear"));
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

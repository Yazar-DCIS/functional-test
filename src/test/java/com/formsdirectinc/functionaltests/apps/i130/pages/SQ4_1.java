package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	private Address spouseInfo;

	private DateTag spouseInfoFrom_Date, spouseInfoTo_Date;

	public SQ4_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_1 spouseResidenceInformations(Properties data, String country,
			int count) {

		if (!country.equalsIgnoreCase("na") && count != -1) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {

					spouseResidenceInfo(data, country, i);

					if ((i < count - 1)) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherAddress();
					}

				}
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void spouseResidenceInfo(Properties data, String country, int count) {
		spouseInfo = new Address(driver,
				"applicationData-spouseInfo.addressInfo[" + count
						+ "].address.country");
		if (country.equalsIgnoreCase("insideUS")) {
			spouseInfo.setCountryDropDown(data.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			spouseInfo.setCountryDropDown(data.getProperty("Country"));
		}

		spouseInfo = new Address(driver,
				"applicationData-spouseInfo.addressInfo[" + count + "].address");
		spouseInfo.setStreet(data.getProperty("StreetName"));

		spouseInfo.setCity(data.getProperty("City"));

		spouseInfo.setZipcode(data.getProperty("Zipcode"));

		spouseInfo = new Address(driver,
				"applicationData-spouseInfo.addressInfo[" + count + "].address");
		if (country.equalsIgnoreCase("insideUS")) {
			spouseInfo.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			spouseInfo.setStateText(data.getProperty("State"));
		}

		spouseInfoFrom_Date = new DateTag(driver, "spouseInfo.addressInfo["
				+ count + "].dateRange.fromDate");
		spouseInfoFrom_Date.selectMonth(data.getProperty("month"));
		spouseInfoFrom_Date.selectDay(data.getProperty("DOB_Day"));
		spouseInfoFrom_Date.selectYear(data.getProperty("fromYear"));

		spouseInfoTo_Date = new DateTag(driver, "spouseInfo.addressInfo["
				+ count + "].dateRange.toDate");
		spouseInfoTo_Date.selectMonth(data.getProperty("toMonth"));
		spouseInfoTo_Date.selectDay(data.getProperty("DOB_Day"));
		spouseInfoTo_Date.selectYear(data.getProperty("toYear"));
	}

}

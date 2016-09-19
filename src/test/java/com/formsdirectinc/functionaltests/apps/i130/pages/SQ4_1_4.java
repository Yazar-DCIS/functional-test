package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1_4 extends WizardPage {

	public SQ4_1_4(WebDriver driver) {
		super(driver);

	}

	private YesNo spouseLivingTogether, SpouseLivedTogether;
	private DateTag spouseInfoFrom_Date, spouseInfoTo_Date;
	private Address spouseInfo;

	public SQ4_1_4 generalInfoAboutSpouse(String livingTogether,
			Properties data, String livedTogether, String country) {

		if (!livingTogether.equalsIgnoreCase("na")
				&& !livedTogether.equalsIgnoreCase("na")
				&& !country.equalsIgnoreCase("na")) {

			spouseLivingTogether = new YesNo(driver,
					"spouseInfo.spouseCurrentlyLiveTogether");

			if (livingTogether.equalsIgnoreCase("Yes")) {
				spouseLivingTogether.yes();

				spouseInfoFrom_Date = new DateTag(driver, "spouseInfo.fromDate");
				spouseInfoFrom_Date.selectMonth(data.getProperty("fromMonth"));
				spouseInfoFrom_Date.selectDay(data.getProperty("DOB_Day"));
				spouseInfoFrom_Date.selectYear(data.getProperty("fromYear"));

			}
			else if (livingTogether.equalsIgnoreCase("no")) {
				spouseLivingTogether.no();

				SpouseLivedTogether = new YesNo(driver,
						"spouseInfo.spouseEverLivedTogether");

				if (livedTogether.equalsIgnoreCase("Yes")) {
					SpouseLivedTogether.yes();

					spouseInfo = new Address(driver,
							"applicationData-spouseInfo.mostRecentLivedAddress.country");
					if (country.equalsIgnoreCase("insideUS")) {
						spouseInfo.setCountryDropDown(data
								.getProperty("DACA_Country"));
					}
					else if (country.equalsIgnoreCase("outsideUS")) {
						spouseInfo.setCountryDropDown(data
								.getProperty("Country"));
					}

					spouseInfo = new Address(driver,
							"applicationData-spouseInfo.mostRecentLivedAddress");
					spouseInfo.setStreet(data.getProperty("StreetName"));

					spouseInfo.setCity(data.getProperty("City"));

					spouseInfo.setZipcode(data.getProperty("Zipcode"));

					spouseInfo = new Address(driver,
							"applicationData-spouseInfo.mostRecentLivedAddress");
					if (country.equalsIgnoreCase("insideUS")) {
						spouseInfo.setState(data.getProperty("tripState"));
					}
					else if (country.equalsIgnoreCase("outsideUS")) {
						spouseInfo.setStateText(data.getProperty("State"));
					}

					spouseInfoFrom_Date = new DateTag(driver,
							"spouseInfo.dateRange.fromDate");
					spouseInfoFrom_Date
							.selectDate(data.getProperty("fromDate"));
					spouseInfoTo_Date = new DateTag(driver,
							"spouseInfo.dateRange.toDate");
					spouseInfoTo_Date.selectDate(data.getProperty("toDate"));

				}
				else if (livedTogether.equalsIgnoreCase("no")) {
					SpouseLivedTogether.no();
				}

			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

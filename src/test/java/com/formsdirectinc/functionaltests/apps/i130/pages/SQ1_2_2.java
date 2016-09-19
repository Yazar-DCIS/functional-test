package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2_2 extends WizardPage {

	private Country otherCountry;
	private DateTag fromDate, toDate;
	private Address otherAddress;
	private YesNo addressDetails;

	public SQ1_2_2(WebDriver driver) {
		super(driver);

	}

	public SQ1_2_2 addressVisitedOutsideUSDetails(Properties data,
			String country, String residentYear) {

		if (!country.equalsIgnoreCase("NA")
				&& !residentYear.equalsIgnoreCase("na")) {

			addressDetails = new YesNo(driver, "applicant.livedAnyWhereNotUS");
			if (country.equalsIgnoreCase("insideUs")) {
				addressDetails.no();
			} else if (country.equalsIgnoreCase("outsideUs")) {
				addressDetails.yes();

				addressDetails = new YesNo(driver,
						"applicant.livedMoreThanOneYear");

				if (residentYear.equalsIgnoreCase("moreThanOneYear")) {
					addressDetails.yes();
					addressVisited(data);
				}

				else if (residentYear.equalsIgnoreCase("oneYearOrLess")) {
					addressDetails.no();
				}

			}

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public SQ1_2_2 addressVisited(Properties data) {
		otherCountry = new Country(driver,
				"applicationData-applicant.lastAddressOutsideUS");

		otherCountry.setCountry(data.getProperty("Country"));

		otherAddress = new Address(driver,
				"applicationData-applicant.lastAddressOutsideUS");

		otherAddress.setStateText(data.getProperty("Mail_State"));

		otherAddress.setStreet(data.getProperty("Mail_Street"));
		otherAddress.setCity(data.getProperty("Mail_City"));

		fromDate = new DateTag(driver, "applicant.dateRange.fromDate");
		fromDate.selectDate(data.getProperty("fromDate0"));

		toDate = new DateTag(driver, "applicant.dateRange.toDate");
		toDate.selectDate(data.getProperty("toDate0"));

		return this;

	}

}

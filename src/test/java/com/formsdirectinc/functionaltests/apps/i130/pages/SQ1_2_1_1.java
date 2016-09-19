package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2_1_1 extends WizardPage {

	private Country otherCountry;
	private DateTag fromDate, toDate;
	private Address otherAddress;

	public SQ1_2_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_2_1_1 addressVisitedInLast5YearsDetails(int count,
			Properties data, String country, String calenderYear) {

		if (count != -1 && !country.equalsIgnoreCase("na")
				&& !calenderYear.equalsIgnoreCase("na")) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					addressVisitedInLast5Years(i, data, country, calenderYear);
					if (i < count - 1) {
						CommonInputClasses address = new CommonInputClasses(
								driver);
						address.addAnotherAddress();
					}
				}

			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public SQ1_2_1_1 addressVisitedInLast5Years(int count, Properties data,
			String country, String calenderYear) {
		otherCountry = new Country(driver,
				"applicationData-applicant.addressInfo[" + count + "].address");

		if (country.equalsIgnoreCase("insideUS")) {
			otherCountry.setCountry(data.getProperty("DACA_Country"));
		} else if (country.equalsIgnoreCase("outsideUS")) {
			otherCountry.setCountry(data.getProperty("Country"));
		}

		otherAddress = new Address(driver,
				"applicationData-applicant.addressInfo[" + count + "].address");

		if (country.equalsIgnoreCase("insideUS")) {
			otherAddress.setState(data.getProperty("tripState"));
		}

		else if (country.equalsIgnoreCase("outsideUS")) {
			otherAddress.setStateText(data.getProperty("Mail_State"));
		}

		otherAddress.setStreet(data.getProperty("Mail_Street"));
		otherAddress.setCity(data.getProperty("Mail_City"));
		otherAddress.setZipcode(data.getProperty("Mail_Zipcode"));

		fromDate = new DateTag(driver, "applicant.addressInfo[" + count
				+ "].dateRange.fromDate");
		fromDate.selectDate(data.getProperty("fromDate0"));

		toDate = new DateTag(driver, "applicant.addressInfo[" + count
				+ "].dateRange.toDate");

		if (calenderYear.equalsIgnoreCase("moreThan1Year")) {
			toDate.selectDate(data.getProperty("toDate27"));
		} else if (calenderYear.equalsIgnoreCase("lessThan1Year")) {
			toDate.selectDate(data.getProperty("toDate01_less"));
		}

		return this;

	}

}

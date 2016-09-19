package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_14 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_14 extends WizardPage {

	private YesNo currentlyWorking;

	private Address emp_Address;

	private DateTag dateRangeFrom;

	private AdditionalInfoFields empName;

	public SQ2_14(WebDriver driver) {
		super(driver);

	}

	public SQ2_14 relativeEmploymentDetails(String country, String working,
			Properties data) {

		if (!country.equalsIgnoreCase("na") && !working.equalsIgnoreCase("na")) {

			currentlyWorking = new YesNo(driver, "relative.presentlyWorking");

			if (working.equalsIgnoreCase("Yes")) {
				currentlyWorking.yes();

				relativeEmploymentInfo(country, data);
			}

			else if (working.equalsIgnoreCase("no")) {
				currentlyWorking.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public void relativeEmploymentInfo(String country, Properties data) {
		empName = new AdditionalInfoFields(driver,
				"applicationData-relative.employerName");
		empName.normalText(data.getProperty("empName"));

		emp_Address = new Address(driver,
				"applicationData-relative.employmentAddress.country");
		if (country.equalsIgnoreCase("insideUS")) {
			emp_Address.setCountryDropDown(data.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			emp_Address.setCountryDropDown(data.getProperty("Country"));
		}

		emp_Address = new Address(driver,
				"applicationData-relative.employmentAddress");
		emp_Address.setStreet(data.getProperty("StreetName"));

		emp_Address.setCity(data.getProperty("City"));

		if (country.equalsIgnoreCase("insideUS")) {
			emp_Address.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			emp_Address.setStateText(data.getProperty("State"));
		}

		emp_Address.setZipcode(data.getProperty("Zipcode"));

		dateRangeFrom = new DateTag(driver, "relative.employmentBegan");
		dateRangeFrom.selectDate(data.getProperty("fromDate"));

	}

}

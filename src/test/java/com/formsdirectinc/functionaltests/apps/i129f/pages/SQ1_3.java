package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {
	private YesNo residence;
	private Address foreignAddress;
	private DateTag livedFrom, livedTo;

	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_3 foreignResidence(Properties data,
			String livedOutSideUSForMoreThanOneYear) {
		if (!livedOutSideUSForMoreThanOneYear.equalsIgnoreCase("NA")) {
			residence = new YesNo(driver, "applicant.livedOutsideUS");
			if (livedOutSideUSForMoreThanOneYear.equalsIgnoreCase("Yes")) {
				residence.yes();

				foreignAddress = new Address(driver,
						"applicationData-applicant.addressOutsideUS.country");
				foreignAddress.setCountryDropDown(data
						.getProperty("I134_Country"));

				foreignAddress = new Address(driver,
						"applicationData-applicant.addressOutsideUS");
				foreignAddress.setStreet(data.getProperty("I134_Street"));
				foreignAddress.setCity(data.getProperty("I134_City"));
				foreignAddress.setStateText(data.getProperty("I134_State"));

				livedFrom = new DateTag(driver,
						"applicant.datesAtAddress.fromDate");
				livedTo = new DateTag(driver, "applicant.datesAtAddress.toDate");

				livedFrom.selectDate(data.getProperty("fromDate"));
				livedTo.selectDate(data.getProperty("toDate"));
			}
			else if (livedOutSideUSForMoreThanOneYear.equalsIgnoreCase("No")) {
				residence.no();
			}
			saveScreenShot("i129f", "SQ1_3"); clickContinueInSQ();
		}
		return this;
	}
}

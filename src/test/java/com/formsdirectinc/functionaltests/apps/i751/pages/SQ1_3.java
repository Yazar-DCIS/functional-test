package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {

	private YesNo sameAddress, careOf;

	private CommonInputClasses applicantAddress;
	public Address applicantCountry;

	public SQ1_3(WebDriver driver) {
		super(driver);

	}

	public SQ1_3 applicantResidenceDetails(Properties data) {
		applicantAddress = new CommonInputClasses(driver);

		applicantAddress.applicantOtherAddressDetails(
				"applicationData-applicant.homeAddressInCareOf", data);

		sameAddress = new YesNo(driver, "formSpecific.sameAsHomeAddress");
		sameAddress.yes();

		careOf = new YesNo(driver,
				"applicant.homeAddressInCareOf.hasInCareOfAgent");
		careOf.no();

		return this;
	}

	public void applicantResidenceCountry(Properties data) {

		applicantCountry = new Address(driver,
				"applicationData-applicant.homeAddressInCareOf.country");

		applicantCountry.setCountryDropDown(data.getProperty("Country"));

	}

}

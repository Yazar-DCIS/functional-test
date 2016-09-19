package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_2 extends WizardPage {

	
	

	private CommonInputClasses initialApplication;
	private Country applicantCountry;
	private YesNo sameAddress;

	public SQ6_2(WebDriver driver) {
		super(driver);

	}

	public void beneficiaryAddressDetails(Properties data) {

		applicantCountry = new Country(driver,
				"applicationData-beneficiary.homeAddress.country");
		applicantCountry.setCountryDDM(data.getProperty("Country"));

		initialApplication = new CommonInputClasses(driver);
		initialApplication.applicantOtherAddressDetails(
				"applicationData-beneficiary.homeAddress", data);

		sameAddress = new YesNo(driver, "beneficiary.sameAddress");
		sameAddress.yes();

		sameAddress = new YesNo(driver, "beneficiary.careOf.hasInCareOfAgent");
		sameAddress.no();

	}

}

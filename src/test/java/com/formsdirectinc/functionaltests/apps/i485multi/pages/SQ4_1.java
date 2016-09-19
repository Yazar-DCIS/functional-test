package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	
	

	private AdditionalInfoFields visaNumber;
	private Country visaCountry;

	public SQ4_1(WebDriver driver) {
		super(driver);

	}

	public void visaNumber(Properties data,String applicanttype) {

		visaNumber = new AdditionalInfoFields(driver,
				"applicationData-"+applicanttype+"Applicant.immigrationStatus.nonimmigrantVisaNumber");
		visaNumber.normalText(data.getProperty("Phone2"));
		visaCountry = new Country(driver,
				"applicationData-"+applicanttype+"Applicant.immigrationStatus.placeVisaIssued.country");
		visaCountry.setCountryDDM(data.getProperty("Country"));
	}



}

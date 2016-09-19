package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_4 extends WizardPage {

	private DateTag applicantDOB;
	private Country applicantCountry;

	public SQ6_4(WebDriver driver) {
		super(driver);

	}

	public void beneficiaryBirthDetails(Properties data) {
		applicantDOB = new DateTag(driver, "beneficiary.dateOfBirth");
		applicantDOB.selectDate(data.getProperty("DOB"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		applicantCountry = new Country(driver, "applicationData-beneficiary");
		applicantCountry.setBirthCountry(data.getProperty("Country"));
		

		applicantCountry = new Country(driver, "applicationData-beneficiary");
		applicantCountry.setBirthCountry(data.getProperty("Country"));

	}

}

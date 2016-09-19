package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_2 extends WizardPage {

	protected YesNo sameAddress;
	protected YesNo hasMotherDeceased;
	protected DateTag motherDateOfDeath;
	protected Address street, country, state;

	public SQ6_2(WebDriver driver) {
		super(driver);

	}

	public SQ6_2 motherInformation(Properties data, String motherDeceased,
			String sameAddresses, String birthCountry) {

		if (!motherDeceased.equalsIgnoreCase("NA")
				&& !sameAddresses.equalsIgnoreCase("NA")) {

			hasMotherDeceased = new YesNo(driver,
					"applicant.motherInfo.deceased");
			hasMotherDeceased.setYesOrNo(motherDeceased);
			if (motherDeceased.equalsIgnoreCase("Yes")) {
				motherDateOfDeath = new DateTag(driver,
						"applicant.motherInfo.deathDate");
				motherDateOfDeath.selectDateAsSingle(data
						.getProperty("DateOfBirth"));
			}

			if (motherDeceased.equalsIgnoreCase("No")) {
				sameAddress = new YesNo(driver,
						"applicant.motherInfo.sameAsApplicantAddress");
				sameAddress.setYesOrNo(sameAddresses);
				if (sameAddresses.equalsIgnoreCase("No")) {
					motherAddress(data, birthCountry);
				}

			}

			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public SQ6_2 motherAddress(Properties data, String birthCountry) {

		country = new Address(driver,
				"applicationData-applicant.motherInfo.address.country");
		if (birthCountry.equalsIgnoreCase("isUS")) {
			country.setCountry(data.getProperty("DACA_Country"));
		}
		if (birthCountry.equalsIgnoreCase("notUS")) {
			country.setCountry(data.getProperty("Country"));
		}

		saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (birthCountry.equalsIgnoreCase("isUS")) {
			country = new Address(driver,
					"applicationData-applicant.motherInfo.address.country");
			country.setCountry(data.getProperty("DACA_Country"));
		}
		if (birthCountry.equalsIgnoreCase("notUS")) {
			country = new Address(driver,
					"applicationData-applicant.motherInfo.address.country");
			country.setCountry(data.getProperty("Country"));
		}

		saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		street = new Address(driver,
				"applicationData-applicant.motherInfo.address");
		street.setStreet(data.getProperty("StreetName"));
		if (birthCountry.equalsIgnoreCase("isUS")) {
			street.setState(data.getProperty("State"));
		}
		street.setCity(data.getProperty("City"));
		street.setZipcode(data.getProperty("Zipcode"));

		return this;

	}

}

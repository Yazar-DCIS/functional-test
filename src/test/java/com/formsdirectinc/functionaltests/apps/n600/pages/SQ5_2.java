package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_2 extends WizardPage {

	protected CheckBox sameAddress;
	protected YesNo hasFatherDeceased;
	protected DateTag fatherDateOfDeath;
	protected Address street, country, state;

	public SQ5_2(WebDriver driver) {
		super(driver);

	}

	public SQ5_2 fatherInformation(Properties data, String fatherDeceased,
			String sameAddresses, String birthCountry) {

		if (!fatherDeceased.equalsIgnoreCase("NA")
				&& !sameAddresses.equalsIgnoreCase("NA")) {

			hasFatherDeceased = new YesNo(driver,
					"applicant.fatherInfo.deceased");

			if (fatherDeceased.equalsIgnoreCase("Yes")) {
				hasFatherDeceased.yes();
				fatherDateOfDeath = new DateTag(driver,
						"applicant.fatherInfo.deathDate");
				fatherDateOfDeath.selectDateAsSingle(data
						.getProperty("DateOfBirth"));
			}

			else if (fatherDeceased.equalsIgnoreCase("No")) {
				hasFatherDeceased.no();
				sameAddress = new CheckBox(driver,
						"applicationData-applicant.fatherInfo.sameAsApplicantAddress");

				if (sameAddresses.equalsIgnoreCase("Yes")) {
					sameAddress.check();
				}

				else if (sameAddresses.equalsIgnoreCase("No")) {
					fatherAddress(data, birthCountry);
				}

			}
			saveScreenShot("n600", "SQ5_2"); clickContinueInSQ();
		}
		return this;

	}

	public SQ5_2 fatherAddress(Properties data, String birthCountry) {
		country = new Address(driver,
				"applicationData-applicant.fatherInfo.address.country");
		if (birthCountry.equalsIgnoreCase("isUS")) {
			country.setCountry(data.getProperty("DACA_Country"));
		}
		else if (birthCountry.equalsIgnoreCase("notUS")) {
			country.setCountry(data.getProperty("Country"));
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (birthCountry.equalsIgnoreCase("isUS")) {
			country.setCountry(data.getProperty("DACA_Country"));
		}
		else if (birthCountry.equalsIgnoreCase("notUS")) {
			country.setCountry(data.getProperty("Country"));
		}
		street = new Address(driver,
				"applicationData-applicant.fatherInfo.address");
		street.setStreet(data.getProperty("StreetName"));
		if (birthCountry.equalsIgnoreCase("isUS")) {
			street.setState(data.getProperty("State"));
		}
		street.setCity(data.getProperty("City"));
		street.setZipcode(data.getProperty("Zipcode"));

		return this;

	}

}

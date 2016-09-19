
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1_1 extends WizardPage {

	protected DateTag dateOfAdoption, dateOfLegalCustody,
			dateOfPhysicalCustody;
	protected Address adopCity, adopCountry, adopState;

	public SQ4_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1_1 applicantAdopted(Properties data, String flow) {

		if (!flow.equalsIgnoreCase("na")) {
			dateOfAdoption = new DateTag(driver,
					"applicant.additionalInfo.adoption.dateOfAdoptionNaturalized");
			dateOfAdoption.selectDate(data.getProperty("DOB"));

			adopCity = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountryNaturalized");
			adopCity.setCity(data.getProperty("City"));

			adopCountry = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountryNaturalized.country");
			adopCountry.setCountry(data.getProperty("Country"));

			adopState = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountryNaturalized");
			adopState.setState(data.getProperty("State"));

			dateOfLegalCustody = new DateTag(
					driver,

					"applicant.additionalInfo.adoption.dateOfLegalAndPhysicalCustodyNaturalized.fromDate");
			dateOfLegalCustody.selectDate(data.getProperty("fromDate"));

			dateOfPhysicalCustody = new DateTag(
					driver,

					"applicant.additionalInfo.adoption.dateOfLegalAndPhysicalCustodyNaturalized.toDate");
			dateOfPhysicalCustody.selectDate(data.getProperty("toDate"));

			saveScreenShot("n600", "SQ4_1_1"); clickContinueInSQ();
		}
		return this;

	}

}

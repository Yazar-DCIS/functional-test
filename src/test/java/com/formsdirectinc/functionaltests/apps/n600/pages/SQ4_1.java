
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	protected YesNo wasApplicantAdopted;
	protected DateTag dateOfAdoption, dateOfLegalCustody,
			dateOfPhysicalCustody;
	protected Address adopCity, adopCountry, adopState;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 applicantAdopted(String adopted, Properties data) {
		wasApplicantAdopted = new YesNo(driver,
				"applicant.additionalInfo.adoption.hasAdopted");

		if (adopted.equalsIgnoreCase("Yes")) {
			wasApplicantAdopted.yes();

			dateOfAdoption = new DateTag(driver,
					"applicant.additionalInfo.adoption.dateOfAdoption");
			dateOfAdoption.selectDate("01-01-2001");

			adopCity = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountry");
			adopCity.setCity(data.getProperty("tripCity"));

			adopCountry = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountry.country");
			adopCountry.setCountry(data.getProperty("Country"));

			adopState = new Address(driver,
					"applicationData-formSpecific.adoptCityStateCountry");
			adopState.setState(data.getProperty("tripState"));

			dateOfLegalCustody = new DateTag(driver,
					"applicant.additionalInfo.adoption.dateOfLegalAndPhysicalCustody.fromDate");
			dateOfLegalCustody.selectDate(data.getProperty("fromDate"));

			dateOfPhysicalCustody = new DateTag(driver,
					"applicant.additionalInfo.adoption.dateOfLegalAndPhysicalCustody.toDate");
			dateOfPhysicalCustody.selectDate(data.getProperty("toDate"));

		}

		if (adopted.equalsIgnoreCase("No")) {
			wasApplicantAdopted.no();
		}

		return this;

	}

	public SQ4_1 applicantNotAdopted() {
		wasApplicantAdopted = new YesNo(driver,
				"applicant.additionalInfo.adoption.hasAdopted");
		wasApplicantAdopted.no();
		return this;
	}

}

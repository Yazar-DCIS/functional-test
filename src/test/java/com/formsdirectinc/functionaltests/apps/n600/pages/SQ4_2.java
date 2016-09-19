
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {

	protected YesNo wasApplicant_ReAdopted;
	protected DateTag dateOf_ReAdoption, dateOf_ReLegalCustody,
			dateOf_RePhysicalCustody;
	protected Address reAdopCity, reAdopState;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 applicantReAdoption(String reAdopted, Properties data) {

		if (!reAdopted.equalsIgnoreCase("NA")) {

			wasApplicant_ReAdopted = new YesNo(driver,
					"applicant.additionalInfo.adoption.hasReAdopted");

			if (reAdopted.equalsIgnoreCase("Yes")) {
				wasApplicant_ReAdopted.yes();

				dateOf_ReAdoption = new DateTag(driver,
						"applicant.additionalInfo.adoption.dateOfReAdoption");
				dateOf_ReAdoption.selectDate(data.getProperty("DOB"));

				reAdopCity = new Address(driver,
						"applicationData-applicant.additionalInfo.adoption.placeOfFinalReAdoption");
				reAdopCity.setVisaCity(data.getProperty("tripCity"));

				reAdopState = new Address(driver,
						"applicationData-applicant.additionalInfo.adoption.placeOfFinalReAdoption");
				reAdopState.setState(data.getProperty("tripState0"));

				dateOf_ReLegalCustody = new DateTag(driver,
						"applicant.additionalInfo.adoption.dateOfReLegalAndPhysicalCustody.fromDate");
				dateOf_ReLegalCustody.selectDate(data.getProperty("fromDate"));

				dateOf_RePhysicalCustody = new DateTag(driver,

				"applicant.additionalInfo.adoption.dateOfReLegalAndPhysicalCustody.toDate");
				dateOf_RePhysicalCustody.selectDate(data.getProperty("toDate"));

			}

			if (reAdopted.equalsIgnoreCase("No")) {
				wasApplicant_ReAdopted.no();
			}
			saveScreenShot("n600", "SQ4_2"); clickContinueInSQ();
		}

		return this;

	}

}

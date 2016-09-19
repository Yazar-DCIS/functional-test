package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_3 extends WizardPage {

	public SQ5_3(WebDriver driver) {
		super(driver);
	}

	public SQ5_3 travelDetails(Properties data, String returnedCountry,
			String entryPermitCountry, String countryBenefittedFrom) {
		if (!returnedCountry.equalsIgnoreCase("NA")) {
			
			CrimeDetails travelRelated=new CrimeDetails(driver);
			travelRelated.informationRelatedToCrime("i131", "applicant.returnedCountry", returnedCountry);
			travelRelated.informationRelatedToCrime("i131", "applicant.entryPermitCountry", entryPermitCountry);
			travelRelated.informationRelatedToCrime("i131", "applicant.countryBenefittedFrom", countryBenefittedFrom);
			

			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}
}

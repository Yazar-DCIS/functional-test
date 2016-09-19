package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_4 extends WizardPage {
	private AdditionalInfoFields purpose;

	public SQ3_4(WebDriver driver) {
		super(driver);
	}

	public SQ3_4 puropseOfTrip(Properties data, String purposeOfVisit) {
		if (!purposeOfVisit.equalsIgnoreCase("NA")) {
			
			purpose = new AdditionalInfoFields(driver,
					"applicationData-applicant.purposeOfTrip");
			purpose.normalText(data.getProperty("I131_Purpose"));
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

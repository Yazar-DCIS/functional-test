package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1_1 extends WizardPage {

	private AdditionalInfoFields placeOfAdmission;

	public SQ3_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_1 placeOfAdmissionStamped(Properties data,
			String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {
			placeOfAdmission = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.placeOfAdmissionOnI94");
			placeOfAdmission.normalText(data.getProperty("City"));
			saveScreenShot("I102", "SQ3_1_1"); clickContinueInSQ();
		}

		return this;

	}

}

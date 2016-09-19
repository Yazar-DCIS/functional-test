package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_1 extends WizardPage {

	private AdditionalInfoFields typeOfPetition;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 typeOfPetition(Properties data, String visitPage) {

		if (!(visitPage.equalsIgnoreCase("skip"))) {

			typeOfPetition = new AdditionalInfoFields(driver,

			"applicationData-petitionInfo.petitionFormNumber");
			typeOfPetition.isStatusOther(data.getProperty("PassportNumber"));

			saveScreenShot("I102", "SQ4_1"); clickContinueInSQ();
		}
		return this;
	}

}

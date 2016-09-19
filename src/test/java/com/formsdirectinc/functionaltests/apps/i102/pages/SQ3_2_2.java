package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_2_2 extends WizardPage {
	
	private AdditionalInfoFields immigrantStatus;

	public SQ3_2_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2_2 nonimmigrantStatus(Properties data, String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {

			immigrantStatus = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.currentNonImmigrantStatus");
			immigrantStatus.normalText(data.getProperty("entryStatus"));

			saveScreenShot("I102", "SQ3_2_2"); clickContinueInSQ();

		}

		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_2_1 extends WizardPage {

	private AdditionalInfoFields immigrantStatus;

	public SQ3_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_2_1 nonimmigrantStatusOnTheDocument(Properties data,
			String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {

			immigrantStatus = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.classOfAdmissionOnI94");
			immigrantStatus.normalText(data.getProperty("entryStatus"));

			saveScreenShot("I102", "SQ3_2_1"); clickContinueInSQ();

		}

		return this;
	}

}

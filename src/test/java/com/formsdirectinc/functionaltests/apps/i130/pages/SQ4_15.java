package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_15 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_15 extends WizardPage {

	private AdditionalInfoFields relativeStatus;

	public SQ4_15(WebDriver driver) {
		super(driver);

	}

	public SQ4_15 spouseStatusInUS(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			relativeStatus = new AdditionalInfoFields(driver,
					"applicationData-spouseInfo.lastEnterStatus");
			relativeStatus.normalText(data.getProperty("status_visitor"));
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

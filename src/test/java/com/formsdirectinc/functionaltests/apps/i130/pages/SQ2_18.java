package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_18 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_18 extends WizardPage {

	private AdditionalInfoFields relativeStatus;

	public SQ2_18(WebDriver driver) {
		super(driver);

	}

	public SQ2_18 relativeStatusInUS(Properties data, String visitPage) {
		if (visitPage.equalsIgnoreCase("yes")) {
			relativeStatus = new AdditionalInfoFields(driver,
					"applicationData-relative.status");
			relativeStatus.normalText(data.getProperty("status_visitor"));

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

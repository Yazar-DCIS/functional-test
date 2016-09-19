package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ5_1 extends WizardPage {

	private MultiRadioOptions agreeToAcknowledgements;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 agreeToSubmit(String agreeToAcknowledgement) {

		if (agreeToAcknowledgement.equalsIgnoreCase("yes")
				|| agreeToAcknowledgement.equalsIgnoreCase("no")) {

			agreeToAcknowledgements = new MultiRadioOptions(driver,"applicationData-formSpecific.declaration");

			if (agreeToAcknowledgement.equalsIgnoreCase("yes")) {
				agreeToAcknowledgements.selectOption(1);
			}

			else if (agreeToAcknowledgement.equalsIgnoreCase("no")) {
				agreeToAcknowledgements.selectOption(2);
			}

		}
		saveScreenShot("i751", "SQ5_1"); clickContinueInSQ();

		return this;
	}
}

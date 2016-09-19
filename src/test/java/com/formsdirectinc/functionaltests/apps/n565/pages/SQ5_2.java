package com.formsdirectinc.functionaltests.apps.n565.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_2 extends WizardPage {

	private MultiRadioOptions agreeToAcknowledgements;

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_2 agreeToSubmit(String agreeToAcknowledgement) {

		if (agreeToAcknowledgement.equalsIgnoreCase("yes")
				|| agreeToAcknowledgement.equalsIgnoreCase("no")) {

			agreeToAcknowledgements = new MultiRadioOptions(driver,

			"applicationData-applicant.acknowledgements");

			if (agreeToAcknowledgement.equalsIgnoreCase("yes")) {
				agreeToAcknowledgements.selectOption(1);
			}

			else if (agreeToAcknowledgement.equalsIgnoreCase("no")) {
				agreeToAcknowledgements.selectOption(2);
			}

		}
		saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}

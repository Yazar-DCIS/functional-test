package com.formsdirectinc.functionaltests.apps.n565.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1 extends WizardPage {

	private MultiRadioOptions knowEnglish;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 interpreterInfo(String haveIntrepretor) {

		if (haveIntrepretor.equalsIgnoreCase("Yes")
				|| haveIntrepretor.equalsIgnoreCase("No")) {

			knowEnglish = new MultiRadioOptions(driver,
					"applicationData-applicant.certification.readAndUnderstandEnglish");

			if (haveIntrepretor.equalsIgnoreCase("no")) {
				knowEnglish.selectOption(1);
			}

			else if (haveIntrepretor.equalsIgnoreCase("yes")) {
				knowEnglish.selectOption(2);
			}

			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}

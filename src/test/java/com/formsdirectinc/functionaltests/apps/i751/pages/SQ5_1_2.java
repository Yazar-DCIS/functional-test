package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1_2 extends WizardPage {

	private MultiRadioOptions declarationTwoAgreement;

	public SQ5_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_2 declarationTwo(String declarationTwo) {

		if (declarationTwo.equalsIgnoreCase("Yes")
				|| declarationTwo.equalsIgnoreCase("No")) {

			declarationTwoAgreement = new MultiRadioOptions(driver,
					"applicationData-formSpecific.declarationTwo");

			if (declarationTwo.equalsIgnoreCase("YES")) {
				declarationTwoAgreement.selectOption(1);
			}

			else if (declarationTwo.equalsIgnoreCase("NO")) {
				declarationTwoAgreement.selectOption(2);
			}

			saveScreenShot("i751", "SQ5_1_2"); clickContinueInSQ();
		}

		return this;
	}
}

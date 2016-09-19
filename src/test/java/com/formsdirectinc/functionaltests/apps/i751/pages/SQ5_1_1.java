package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1_1 extends WizardPage {

	private MultiRadioOptions knowEnglish;

	public SQ5_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_1 haveEnglishKnowledge(String haveEnglishKnowledge) {

		if (haveEnglishKnowledge.equalsIgnoreCase("Yes")
				|| haveEnglishKnowledge.equalsIgnoreCase("No")) {

			knowEnglish = new MultiRadioOptions(driver,
					"applicationData-formSpecific.readAndUnderstandEnglish");

			if (haveEnglishKnowledge.equalsIgnoreCase("yes")) {
				knowEnglish.selectOption(1);
			}

			if (haveEnglishKnowledge.equalsIgnoreCase("no")) {
				knowEnglish.selectOption(2);
			}

			knowEnglish = new MultiRadioOptions(driver,
					"applicationData-formSpecific.interpreterReadEnglish");

			if (haveEnglishKnowledge.equalsIgnoreCase("yes")) {
				knowEnglish.selectOption(1);
			}

			if (haveEnglishKnowledge.equalsIgnoreCase("no")) {
				knowEnglish.selectOption(2);
			}
			saveScreenShot("i751", "SQ5_1_1"); clickContinueInSQ();
		}

		return this;
	}
}

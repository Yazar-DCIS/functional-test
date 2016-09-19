package com.formsdirectinc.functionaltests.apps.i102.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_1_1 extends WizardPage {

	public SQ1_1_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_1_1 clickContinue(String attentionReguired) {
		if (!attentionReguired.equalsIgnoreCase("Skip")) {
			saveScreenShot("I102", "SQ1_1_1_1"); clickContinueInSQ();
		}
		return this;

	}

}

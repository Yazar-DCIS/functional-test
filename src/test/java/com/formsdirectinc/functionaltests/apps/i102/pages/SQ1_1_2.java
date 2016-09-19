package com.formsdirectinc.functionaltests.apps.i102.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1_2 extends WizardPage {

	private YesNo purposeForApplicaton;

	public SQ1_1_2(WebDriver driver) {
		super(driver);

	}

	public SQ1_1_2 includeAnotherPetition(String simultaneousApplication) {

		if (!simultaneousApplication.equalsIgnoreCase("Skip")) {
			purposeForApplicaton = new YesNo(driver,"eligibilityInfo.purposeOfFiling");
			purposeForApplicaton.setYesOrNo(simultaneousApplication);
			saveScreenShot("I102", "SQ1_1_2"); clickContinueInSQ();
		}

		return this;
	}

}

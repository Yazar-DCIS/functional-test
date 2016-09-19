package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_10 extends WizardPage {
	private YesNo unlawfulPresence;

	public SQ1_10(WebDriver driver) {
		super(driver);
	}

	public SQ1_10 unlawfulPresence(String legalStatus) {
		if (!legalStatus.equalsIgnoreCase("NA")) {
			
			unlawfulPresence = new YesNo(driver, "applicant.livedWithoutStatus");
			unlawfulPresence.setYesOrNo(legalStatus);
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_8 extends WizardPage {
	private YesNo currentStatus;

	public SQ1_8(WebDriver driver) {
		super(driver);
	}

	public SQ1_8 inUs(String currentlyInUs) {
		if (!currentlyInUs.equalsIgnoreCase("NA")) {
			
			currentStatus = new YesNo(driver, "applicant.currentlyInUS");
			currentStatus.setYesOrNo(currentlyInUs);
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2 extends WizardPage {
	private YesNo lengthOfTrip;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 departUs(String departUs) {
		if (!departUs.equalsIgnoreCase("NA")) {
			
			lengthOfTrip = new YesNo(driver,
					"applicant.departUSForOneYearOrMore");
			lengthOfTrip.setYesOrNo(departUs);
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}
}

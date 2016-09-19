package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_12 extends WizardPage {

	private YesNo lprThroughMarriage;

	public SQ1_12(WebDriver driver) {
		super(driver);

	}

	public SQ1_12 permanentResidentThroughMarriage(
			String residentThroughMarriageAnswer) {

		if (!residentThroughMarriageAnswer.equalsIgnoreCase("na")) {
			lprThroughMarriage = new YesNo(driver,
					"applicant.lprThroughMarriage");
			lprThroughMarriage.setYesOrNo(residentThroughMarriageAnswer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

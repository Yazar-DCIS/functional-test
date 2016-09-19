package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_16 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_16 extends WizardPage {

	private YesNo stepParentMarriedToYourNaturalParent;

	public SQ2_2_16(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_16 stepParentMarriedToYourNaturalParent(
			String stepParentMarriedNaturalParent) {

		if (!stepParentMarriedNaturalParent.equalsIgnoreCase("na")) {
			stepParentMarriedToYourNaturalParent = new YesNo(driver,
					"relative.stepParentMarriedToYourNaturalParent");
			stepParentMarriedToYourNaturalParent.setYesOrNo(stepParentMarriedNaturalParent);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

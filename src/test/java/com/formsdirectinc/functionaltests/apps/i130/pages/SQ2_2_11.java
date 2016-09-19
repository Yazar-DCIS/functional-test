package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_11 extends WizardPage {

	private YesNo parentsMarriedBeforeYouBorn;

	public SQ2_2_11(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_11 parentsMarriedBeforeYouBorn(String parentsMarried) {

		if (!parentsMarried.equalsIgnoreCase("na")) {
			parentsMarriedBeforeYouBorn = new YesNo(driver,
					"relative.parentsMarriedBeforeYouBorn");
			parentsMarriedBeforeYouBorn.setYesOrNo(parentsMarried);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

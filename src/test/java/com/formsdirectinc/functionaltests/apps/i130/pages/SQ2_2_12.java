package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_12 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_12 extends WizardPage {

	private YesNo parentsStillMarried;

	public SQ2_2_12(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_12 parentsStillMarried(String parentsMarried) {

		if (!parentsMarried.equalsIgnoreCase("na")) {

			parentsStillMarried = new YesNo(driver,
					"relative.parentsStillMarried");

			parentsStillMarried.setYesOrNo(parentsMarried);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_17 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_17 extends WizardPage {

	private YesNo parentsStillMarried;

	public SQ2_2_17(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_17 yourParentsStillMarried(String parentsMarried) {

		if (!parentsMarried.equalsIgnoreCase("na")) {

			parentsStillMarried = new YesNo(driver,
					"relative.yourParentsStillMarried");

			parentsStillMarried.setYesOrNo(parentsMarried);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

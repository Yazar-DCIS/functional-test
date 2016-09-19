package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_17 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_17 extends WizardPage {

	private YesNo relativeCurrentlyInUS;

	public SQ2_17(WebDriver driver) {
		super(driver);

	}

	public SQ2_17 relativeCurrentlyInUS(String currentlyInUS) {

		if (currentlyInUS.equalsIgnoreCase("yes")||currentlyInUS.equalsIgnoreCase("no")) {
			relativeCurrentlyInUS = new YesNo(driver, "relative.currentlyInUS");
			relativeCurrentlyInUS.setYesOrNo(currentlyInUS);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_14 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_14 extends WizardPage {

	private YesNo relativeCurrentlyInUS;

	public SQ4_14(WebDriver driver) {
		super(driver);

	}

	public SQ4_14 spouseCurrentlyInUS(String currentlyInUS) {

		if (currentlyInUS.equalsIgnoreCase("yes")||currentlyInUS.equalsIgnoreCase("no")) {
			relativeCurrentlyInUS = new YesNo(driver,"spouseInfo.currentlyInUS");
			relativeCurrentlyInUS.setYesOrNo(currentlyInUS);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_13 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_13 extends WizardPage {

	private YesNo relativeBeenInUS;

	public SQ4_13(WebDriver driver) {
		super(driver);

	}

	public SQ4_13 spouseBeenToUS(String beenInUS) {

		if (beenInUS.equalsIgnoreCase("yes")||beenInUS.equalsIgnoreCase("no")) {
			relativeBeenInUS = new YesNo(driver, "spouseInfo.beenInUS");
			relativeBeenInUS.setYesOrNo(beenInUS);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_16 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_16 extends WizardPage {

	private YesNo relativeBeenInUS;

	public SQ2_16(WebDriver driver) {
		super(driver);

	}

	public SQ2_16 relativeBeenToUS(String beenInUS) {

		if (beenInUS.equalsIgnoreCase("yes")||beenInUS.equalsIgnoreCase("no")) {

			relativeBeenInUS = new YesNo(driver, "relative.beenInUS");
			relativeBeenInUS.setYesOrNo(beenInUS);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

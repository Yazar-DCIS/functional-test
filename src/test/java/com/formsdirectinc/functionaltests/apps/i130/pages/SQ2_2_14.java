package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2_14 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_14 extends WizardPage {

	private YesNo legitimateBefore18thBirthday;

	public SQ2_2_14(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_14 legitimateBeforeEighteenthBirthday(String legimate) {
		if (!legimate.equalsIgnoreCase("na")) {
			legitimateBefore18thBirthday = new YesNo(driver,
					"relative.legitimateBeforeEighteenthBirthday");
			legitimateBefore18thBirthday.setYesOrNo(legimate);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

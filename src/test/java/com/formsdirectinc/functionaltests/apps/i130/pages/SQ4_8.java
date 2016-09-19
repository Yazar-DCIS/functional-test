package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_8 extends WizardPage {

	private YesNo useRomanLetters;

	public SQ4_8(WebDriver driver) {
		super(driver);

	}

	public SQ4_8 spouseFamilyUseRomanLetters(String usedRomanLetters) {

		if (usedRomanLetters.equalsIgnoreCase("no")||usedRomanLetters.equalsIgnoreCase("yes")) {
			useRomanLetters = new YesNo(driver, "spouseInfo.useRomanLetters");
			useRomanLetters.setYesOrNo(usedRomanLetters);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

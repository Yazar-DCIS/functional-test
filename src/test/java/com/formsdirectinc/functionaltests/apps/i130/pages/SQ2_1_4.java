package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1_4 extends WizardPage {

	private YesNo spouseHasDeceased;

	public SQ2_1_4(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_4 permenentResident_SpouseInfo(String spouseDeceased) {

		if (!spouseDeceased.equalsIgnoreCase("na")) {
			spouseHasDeceased = new YesNo(driver, "relative.nowDeceased");

			spouseHasDeceased.setYesOrNo(spouseDeceased);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

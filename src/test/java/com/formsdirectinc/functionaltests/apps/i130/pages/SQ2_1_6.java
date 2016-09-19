package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1_6 extends WizardPage {

	private YesNo childHasMarried;

	public SQ2_1_6(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_6 childDetailsAboutMarriage(String childMarried) {

		if (!childMarried.equalsIgnoreCase("na")) {
			childHasMarried = new YesNo(driver, "relative.childNotMmarried");
			childHasMarried.setYesOrNo(childMarried);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

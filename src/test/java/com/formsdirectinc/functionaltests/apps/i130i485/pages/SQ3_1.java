package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	private YesNo presenceInUS;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 presenceInUS(String bothCurrentlyLiveUS) {
		presenceInUS = new YesNo(driver, "applicant.bothCurrentlyLiveUS");
		presenceInUS.setYesOrNo(bothCurrentlyLiveUS);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

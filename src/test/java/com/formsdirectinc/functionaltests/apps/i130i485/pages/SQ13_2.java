package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ13_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ13_2 extends WizardPage {

	private CheckBox certify;

	public SQ13_2(WebDriver driver) {
		super(driver);
	}

	public SQ13_2 relativeDisclaimerStatement() {

		certify = new CheckBox(driver,
				"applicationData-foreignRelative.statement.disclaimer.optionList[1].value-1");
		certify.check();
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

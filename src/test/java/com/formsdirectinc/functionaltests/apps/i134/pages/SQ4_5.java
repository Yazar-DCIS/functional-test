package com.formsdirectinc.functionaltests.apps.i134.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_5 extends WizardPage {
	private CheckBox affirmationOne;

	public SQ4_5(WebDriver driver) {
		super(driver);
		affirmationOne = new CheckBox(driver,
				"applicationData-formSpecific.declarationOne");
	}

	public SQ4_5 checkAffirmationOne() {
		affirmationOne.check();
		return this;
	}

}

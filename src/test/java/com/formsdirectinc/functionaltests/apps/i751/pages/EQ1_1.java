package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_1 extends WizardPage {
	private MultiRadioOptions applicationType;

	public EQ1_1(WebDriver driver) {
		super(driver);

	}

	public void set_conditionalGreenCardHolder() {
		applicationType = new MultiRadioOptions(driver,
				"applicationData-quiz.conditionalGreenCardHolder");
		applicationType.selectOption(1);
		saveScreenShot("i751", this.getClass().getSimpleName()); clickContinueInEQ();
	}

}

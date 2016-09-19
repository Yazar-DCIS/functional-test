package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ1_1 extends WizardPage {

	private MultiRadioOptions initialApplication;

	public SQ1_1(WebDriver driver) {
		super(driver);

	}

	public void reasonForApplication() {

		initialApplication = new MultiRadioOptions(driver,
				"applicationData-eligibility.reasonForApplication");
		initialApplication.selectOption(1);

	}

}

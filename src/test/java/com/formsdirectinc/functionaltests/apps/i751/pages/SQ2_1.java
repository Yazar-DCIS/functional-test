package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private MultiRadioOptions applicationType;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public void setAppType() {
		applicationType = new MultiRadioOptions(driver,
				"applicationData-formSpecific.filingOption");
		applicationType.selectOption(1);
	}

}

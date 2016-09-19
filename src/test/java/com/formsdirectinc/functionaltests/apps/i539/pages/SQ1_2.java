package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {

	private MultiRadioOptions reasonForApplication;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public void set_ReasonForApplication() {
		reasonForApplication = new MultiRadioOptions(driver,
				"applicationData-applicant.reasonForApplication");
		reasonForApplication.selectOption(1);
	}

}

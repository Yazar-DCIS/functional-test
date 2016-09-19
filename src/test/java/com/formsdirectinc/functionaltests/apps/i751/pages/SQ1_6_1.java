package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6_1 extends WizardPage {

	private MultiRadioOptions applicationType;

	public SQ1_6_1(WebDriver driver) {
		super(driver);

	}

	public void maritalStatus() {
		applicationType = new MultiRadioOptions(driver,
				"applicationData-applicant.currentMaritalStatus");
		applicationType.selectOption(1);
	}

}

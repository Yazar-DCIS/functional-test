package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ10_2 extends WizardPage {
	private MultiRadioOptions completeApplication;

	public SQ10_2(WebDriver driver) {
		super(driver);

	}

	public void applicantAgreementDetails() {

		completeApplication = new MultiRadioOptions(driver,
				"applicationData-applicant.certification");
		completeApplication.selectOption(1);

	}

}

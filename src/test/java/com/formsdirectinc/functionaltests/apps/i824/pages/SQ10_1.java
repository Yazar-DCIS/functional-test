package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ10_1 extends WizardPage {

	
	

	private MultiRadioOptions completeApplication;

	public SQ10_1(WebDriver driver) {
		super(driver);

	}

	public void applicantCertificationDetails() {

		completeApplication = new MultiRadioOptions(driver,
				"applicationData-interpreter.interpreterHelp");
		completeApplication.selectOption(1);

	}

}

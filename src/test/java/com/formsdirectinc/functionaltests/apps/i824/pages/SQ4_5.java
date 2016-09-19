package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_5 extends WizardPage {

	
	

	private MultiRadioOptions initialApplication;

	public SQ4_5(WebDriver driver) {
		super(driver);

	}

	public void immigrationStatus() {

		initialApplication = new MultiRadioOptions(driver,
				"applicationData-applicant.immigrationStatus");
		initialApplication.selectOption(1);

	}

}

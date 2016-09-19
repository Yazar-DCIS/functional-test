package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	
	

	private MultiRadioOptions initialApplication;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public void qualifyingStatus() {

		initialApplication = new MultiRadioOptions(driver,
				"applicationData-eligibility.basisOfApplyingPersonal");
		initialApplication.selectOption(1);

	}

}

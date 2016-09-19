package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_6 extends WizardPage {

	
	

	private MultiRadioOptions initialApplication;

	public SQ4_6(WebDriver driver) {
		super(driver);

	}

	public void citizenshipStatus() {

		initialApplication = new MultiRadioOptions(driver,
				"applicationData-applicant.obtainCitizenship");
		initialApplication.selectOption(3);

	}

}

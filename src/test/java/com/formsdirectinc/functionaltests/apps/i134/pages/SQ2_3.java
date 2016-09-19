package com.formsdirectinc.functionaltests.apps.i134.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_3 extends WizardPage {
	private MultiRadioOptions selectEmployment;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public SQ2_3 employmentStatus(int option) {
		selectEmployment = new MultiRadioOptions(driver,
				"applicationData-applicant.employmentDetails.employmentStatus");
		selectEmployment.selectOption(option);
		return this;
	}


}

package com.formsdirectinc.functionaltests.apps.i134.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {

	private MultiRadioOptions selectSponsor;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 submittingAOSOnBehalfOf(int option) {
		selectSponsor = new MultiRadioOptions(driver,
				"applicationData-eligibility.submittingAOSOnBehalfOf");
		selectSponsor.selectOption(option);
		return this;
	}


}

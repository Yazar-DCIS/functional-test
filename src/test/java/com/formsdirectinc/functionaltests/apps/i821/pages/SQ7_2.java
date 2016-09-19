package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ7_2 extends WizardPage {

	public SQ7_2(WebDriver driver) {
		super(driver);
	}

	
	
	public SQ7_2 set_Declaration() {
		

		
		MultiRadioOptions declaration = new MultiRadioOptions(driver,
					"applicationData-applicant.certification.declaration");
			declaration.selectOption(1);
		
		saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

	
	
}

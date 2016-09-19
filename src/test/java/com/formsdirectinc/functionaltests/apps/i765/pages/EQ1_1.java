package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_1 extends WizardPage {

	public MultiRadioOptions reasonForI765Application;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 reasonForI765Application(int selectReason) throws Exception {
			
			reasonForI765Application = new MultiRadioOptions(driver,
					"applicationData-quiz.categoriesOfEligibility");
			reasonForI765Application.selectOption(selectReason);
			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();

		
		return this;
	}

}

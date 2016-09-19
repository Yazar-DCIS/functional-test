package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_12_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_12_1 extends WizardPage {

	public MultiRadioOptions applyOptions;

	public EQ1_12_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_12_1 reasonForI765Application(String selectReason)
			throws Exception {
		if (!selectReason.equalsIgnoreCase("NA")) {
			
			applyOptions = new MultiRadioOptions(driver,
					"applicationData-quiz.categoriesOfEligibilityOne");
			if (selectReason.equalsIgnoreCase("renewEAD")) {
				applyOptions.selectOption(1);
			}
			else if (selectReason.equalsIgnoreCase("replaceEAD")) {
				applyOptions.selectOption(2);
			}
			else if (selectReason.equalsIgnoreCase("correctEAD")) {
				applyOptions.selectOption(3);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

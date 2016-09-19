package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_5 extends WizardPage {

	public MultiRadioOptions studentTypeOfApplicant;

	public EQ1_5(WebDriver driver) {
		super(driver);
	}

	public EQ1_5 studentTypeOfApplicant(String studentReason) throws Exception {
		if (!studentReason.equalsIgnoreCase("NA")) {
			
			studentTypeOfApplicant = new MultiRadioOptions(driver,
					"applicationData-quiz.studentType");
			if (studentReason.equalsIgnoreCase("academic")) {
				studentTypeOfApplicant.selectOption(1);
			}
			else if (studentReason.equalsIgnoreCase("vocational")) {
				studentTypeOfApplicant.selectOption(2);
			}
			else if (studentReason.equalsIgnoreCase("None")) {
				studentTypeOfApplicant.selectOption(3);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

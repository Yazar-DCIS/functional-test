package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_11 extends WizardPage {

	public MultiRadioOptions selectoptions;

	public EQ1_11(WebDriver driver) {
		super(driver);
	}

	public EQ1_11 selectReason(String selectReasonForApplication)
			throws Exception {
		if (!selectReasonForApplication.equalsIgnoreCase("NA")) {
			
			selectoptions = new MultiRadioOptions(driver,
					"applicationData-quiz.previouslyAppliedAppnsStatus");
			if (selectReasonForApplication.equalsIgnoreCase("approvedI589")) {
				selectoptions.selectOption(1);
			}
			else if (selectReasonForApplication.equalsIgnoreCase("pendingI881")) {
				selectoptions.selectOption(2);
			}
			else if (selectReasonForApplication.equalsIgnoreCase("grantedDED")) {
				selectoptions.selectOption(3);
			}
			else if (selectReasonForApplication.equalsIgnoreCase("paroled")) {
				selectoptions.selectOption(4);
			}
			else if (selectReasonForApplication.equalsIgnoreCase("none")) {
				selectoptions.selectOption(5);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

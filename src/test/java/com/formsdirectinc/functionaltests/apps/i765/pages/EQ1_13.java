package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_13 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_13 extends WizardPage {

	public MultiRadioOptions chooseOption;

	public EQ1_13(WebDriver driver) {
		super(driver);
	}

	public EQ1_13 selectReasonForApplying(String selectReason) throws Exception {
		if (!selectReason.equalsIgnoreCase("NA")) {
			
			chooseOption = new MultiRadioOptions(driver,
					"applicationData-quiz.previouslyAppliedAppnsStatusOne");
			if (selectReason.equalsIgnoreCase("pendingI485")) {
				chooseOption.selectOption(1);
			}
			else if (selectReason.equalsIgnoreCase("approvedI485")) {
				chooseOption.selectOption(2);
			}
			else if (selectReason.equalsIgnoreCase("DACA")) {
				chooseOption.selectOption(3);
			}
			else if (selectReason.equalsIgnoreCase("personalB1Visa")) {
				chooseOption.selectOption(4);
			}
			else if (selectReason.equalsIgnoreCase("employeeB1Visa")) {
				chooseOption.selectOption(5);
			}
			else if (selectReason.equalsIgnoreCase("U-1Victim")) {
				chooseOption.selectOption(6);
			}
			else if (selectReason.equalsIgnoreCase("T-1Victim")) {
				chooseOption.selectOption(7);
			}
			else if (selectReason.equalsIgnoreCase("v2/v3Visa")) {
				chooseOption.selectOption(8);
			}
			else if (selectReason.equalsIgnoreCase("refugeeStatus")) {
				chooseOption.selectOption(9);
			}
			else if (selectReason.equalsIgnoreCase("none")) {
				chooseOption.selectOption(10);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

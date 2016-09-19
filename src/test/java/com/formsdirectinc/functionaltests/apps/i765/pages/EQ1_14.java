package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_14 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_14 extends WizardPage {

	public MultiRadioOptions chooseOption;

	public EQ1_14(WebDriver driver) {
		super(driver);
	}

	public EQ1_14 selectReason(String selectReason) throws Exception {
		if (!selectReason.equalsIgnoreCase("NA")) {
			
			chooseOption = new MultiRadioOptions(driver,
					"applicationData-quiz.eadApplyingReason");
			if (selectReason.equalsIgnoreCase("replaceEAD")) {
				chooseOption.selectOption(1);
			}
			else if (selectReason.equalsIgnoreCase("correctEAD")) {
				chooseOption.selectOption(2);
			}
			else if (selectReason.equalsIgnoreCase("none")) {
				chooseOption.selectOption(3);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

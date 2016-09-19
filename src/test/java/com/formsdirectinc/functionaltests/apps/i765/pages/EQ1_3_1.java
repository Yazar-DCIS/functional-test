package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_3_1 extends WizardPage {

	public MultiRadioOptions EADCardStatus;

	public EQ1_3_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_3_1 EADCardStatus(String EADCardStatusReason) throws Exception {
		if (!EADCardStatusReason.equalsIgnoreCase("NA")) {
			
			EADCardStatus = new MultiRadioOptions(driver,
					"applicationData-quiz.eadCardStatus");
			if (EADCardStatusReason.equalsIgnoreCase("cardExpired")) {
				EADCardStatus.selectOption(1);
			}
			else if (EADCardStatusReason.equalsIgnoreCase("cardWillExpire")) {
				EADCardStatus.selectOption(2);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

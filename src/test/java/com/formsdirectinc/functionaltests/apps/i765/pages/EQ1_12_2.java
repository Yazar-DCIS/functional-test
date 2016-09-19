package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_12_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_12_2 extends WizardPage {

	public MultiRadioOptions eadCardStatus;

	public EQ1_12_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_12_2 EADCardStatus(String eadCardStatusReason) throws Exception {
		if (!eadCardStatusReason.equalsIgnoreCase("NA")) {
			
			eadCardStatus = new MultiRadioOptions(driver,
					"applicationData-quiz.eadCardStatusOne");
			if (eadCardStatusReason.equalsIgnoreCase("cardExpired")) {
				eadCardStatus.selectOption(1);
			}
			else if (eadCardStatusReason.equalsIgnoreCase("cardWillExpire")) {
				eadCardStatus.selectOption(2);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

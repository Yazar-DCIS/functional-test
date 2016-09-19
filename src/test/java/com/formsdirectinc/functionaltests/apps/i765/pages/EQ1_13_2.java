package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_13_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_13_2 extends WizardPage {

	public YesNo requestEAD;

	public EQ1_13_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_13_2 RequestedForEADCardUstatus(String requestedEADCard)
			throws Exception {
		if (!requestedEADCard.equalsIgnoreCase("NA")) {
			
			requestEAD = new YesNo(driver, "quiz.requestAnEADCardWhenUStatus");
			requestEAD.setYesOrNo(requestedEADCard);
			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_1 extends WizardPage {
	public YesNo receivedi821d1;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 receivedDACA(String received) throws Exception {

		if (received != "skip") {
			receivedi821d1 = new YesNo(driver, "quiz.everReceivedDA");
			receivedi821d1.setYesOrNo(received);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
			}
		return this;
	}

}

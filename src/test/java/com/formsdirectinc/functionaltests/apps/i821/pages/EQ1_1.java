package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1 extends WizardPage {

	private YesNo status;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 usPresent(String uspresence) {

		if (!uspresence.equalsIgnoreCase("NA")) {
			status = new YesNo(driver, "quiz.usPresent");
			status.setYesOrNo(uspresence);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

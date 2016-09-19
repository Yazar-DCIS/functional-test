package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ4_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ4_4 extends WizardPage {

	private YesNo anyCrimes;

	public EQ4_4(WebDriver driver) {
		super(driver);
	}

	public EQ4_4 anyCrimes(String convictedOfAnyCrimes) throws Exception {

		if (!convictedOfAnyCrimes.equalsIgnoreCase("skip")) {
			anyCrimes = new YesNo(driver, "quiz.convictedOfAnyCrimes");
			anyCrimes.setYesOrNo(convictedOfAnyCrimes);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

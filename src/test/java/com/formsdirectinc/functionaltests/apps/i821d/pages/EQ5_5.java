package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_5 extends WizardPage {

	public YesNo convictedOfAnyCrimes;

	public EQ5_5(WebDriver driver) {
		super(driver);
	}

	public EQ5_5 notConvictedAnyCrimes(String convictedofanycrimes)
			throws Exception {

		if (!convictedofanycrimes.equalsIgnoreCase("skip")) {

			convictedOfAnyCrimes = new YesNo(driver,"quiz.convictedOfAnyCrimes");
			convictedOfAnyCrimes.setYesOrNo(convictedofanycrimes);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

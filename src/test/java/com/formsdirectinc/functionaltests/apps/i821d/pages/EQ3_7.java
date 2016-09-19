package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_7 extends WizardPage {

	private YesNo convictedOfAnyCrimes;

	public EQ3_7(WebDriver driver) {
		super(driver);
	}

	public EQ3_7 convictedOfAnyCrimes(String anycrimes) throws Exception {

		if (!anycrimes.equalsIgnoreCase("skip")) {
			convictedOfAnyCrimes = new YesNo(driver,"quiz.convictedOfAnyCrimes");
			convictedOfAnyCrimes.setYesOrNo(anycrimes);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

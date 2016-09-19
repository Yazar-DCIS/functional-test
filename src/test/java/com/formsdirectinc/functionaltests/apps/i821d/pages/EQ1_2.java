package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_2 extends WizardPage {

	public YesNo dacaAlreadyExpired;
	
	public EQ1_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_2 dacaNotExpired(String expire) throws Exception {

		if (!expire.equalsIgnoreCase("skip")) {
			dacaAlreadyExpired = new YesNo(driver, "quiz.dacaAlreadyExpired");
			dacaAlreadyExpired.setYesOrNo(expire);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;

	}

}

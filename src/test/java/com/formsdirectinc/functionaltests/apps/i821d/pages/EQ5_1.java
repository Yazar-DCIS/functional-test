package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_1 extends WizardPage {

	public YesNo expireBefore150Days;
	public Sites site;

	public EQ5_1(WebDriver driver) {
		super(driver);
	}

	public EQ5_1 expireBefore150Days(String expirebefore150days)
			throws Exception {

		if (!expirebefore150days.equalsIgnoreCase("skip")) {
			expireBefore150Days = new YesNo(driver, "quiz.expireBefore150Days");
			expireBefore150Days.setYesOrNo(expirebefore150days);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

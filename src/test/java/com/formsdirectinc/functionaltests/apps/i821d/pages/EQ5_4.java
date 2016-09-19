package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ5_4 extends WizardPage {

	public YesNo livingInUSRightNow;
	public Sites site;

	public EQ5_4(WebDriver driver) {
		super(driver);
	}

	public EQ5_4 livingInUSRightNow(String livinginUSrightnow) throws Exception {

		if (!livinginUSrightnow.equalsIgnoreCase("skip")) {
			livingInUSRightNow = new YesNo(driver, "quiz.livingInUSRightNow");
			livingInUSRightNow.setYesOrNo(livinginUSrightnow);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

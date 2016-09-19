package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ2_2 extends WizardPage {

	private YesNo livinginuS;

	public EQ2_2(WebDriver driver) {
		super(driver);
	}

	public EQ2_2 livingInUSRightNow(String liveinUS) throws Exception {
		if (!liveinUS.equalsIgnoreCase("skip")) {
			livinginuS = new YesNo(driver, "quiz.livingInUSRightNow");
			livinginuS.setYesOrNo(liveinUS);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

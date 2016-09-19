package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_4 extends WizardPage {

	private YesNo passedtheGED;

	public EQ3_4(WebDriver driver) {
		super(driver);
	}

	public EQ3_4 passedTheGED(String passedTheGED) throws Exception {

		if (!passedTheGED.equalsIgnoreCase("skip")) {
			passedtheGED = new YesNo(driver, "quiz.passedTheGED");
			passedtheGED.setYesOrNo(passedTheGED);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

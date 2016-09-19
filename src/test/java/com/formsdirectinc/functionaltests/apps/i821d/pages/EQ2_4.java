package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_4 extends WizardPage {

	private YesNo everLeftUS15June2007;

	public EQ2_4(WebDriver driver) {
		super(driver);
	}

	public EQ2_4 everLeftUS15June2007(String everleftUSjun2007)
			throws Exception {
		if (!everleftUSjun2007.equalsIgnoreCase("skip")) {
			everLeftUS15June2007 = new YesNo(driver,
					"quiz.everLeftUS15June2007");
			everLeftUS15June2007.setYesOrNo(everleftUSjun2007);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

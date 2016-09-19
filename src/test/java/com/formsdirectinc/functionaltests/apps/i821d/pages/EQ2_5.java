package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_5 extends WizardPage {

	private YesNo everLeftUS01January2010;

	public EQ2_5(WebDriver driver) {
		super(driver);
	}

	public EQ2_5 everLeftUS01January2010(String everleftUS01jan)
			throws Exception {
		if (!everleftUS01jan.equalsIgnoreCase("skip")) {
			everLeftUS01January2010 = new YesNo(driver,
					"quiz.everLeftUS01January2010");
			everLeftUS01January2010.setYesOrNo(everleftUS01jan);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

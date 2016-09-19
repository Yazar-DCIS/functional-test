package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ4_3 extends WizardPage {

	private YesNo undocumentedOn20November2014;

	public EQ4_3(WebDriver driver) {
		super(driver);
	}

	public EQ4_3 undocumentedOn20November2014(String undocumentedOn)
			throws Exception {

		if (!undocumentedOn.equalsIgnoreCase("skip")) {
			undocumentedOn20November2014 = new YesNo(driver,
					"quiz.undocumentedOn20November2014");
			undocumentedOn20November2014.setYesOrNo(undocumentedOn);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ3_6 extends WizardPage {

	private YesNo undocumentedOn15June2012;

	public EQ3_6(WebDriver driver) {
		super(driver);
	}

	public EQ3_6 undocumentedOn15June2012(String undocumentedOn15)
			throws Exception {

		if (!undocumentedOn15.equalsIgnoreCase("skip")) {
			undocumentedOn15June2012 = new YesNo(driver,
					"quiz.undocumentedOn15June2012");
			undocumentedOn15June2012.setYesOrNo(undocumentedOn15);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;

	}

}

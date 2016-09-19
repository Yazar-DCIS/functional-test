package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_1 extends WizardPage {

	private YesNo bornOnOrBefore15June1981;

	public EQ3_1(WebDriver driver) {
		super(driver);
	}

	public EQ3_1 bornOnOrBefore15June1981(String bornonOrbefore15)
			throws Exception {
		if (!bornonOrbefore15.equalsIgnoreCase("skip")) {
			bornOnOrBefore15June1981 = new YesNo(driver,
					"quiz.bornOnOrBefore15June1981");
			bornOnOrBefore15June1981.setYesOrNo(bornonOrbefore15);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

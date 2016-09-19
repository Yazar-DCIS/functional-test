package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ4_1 extends WizardPage {

	private YesNo childUSCitizenOn20November2014;

	public EQ4_1(WebDriver driver) {
		super(driver);
	}

	public EQ4_1 childUSCitizenOn20November2014(String childUScitizen)
			throws Exception {

		if (!childUScitizen.equalsIgnoreCase("skip")) {
			childUSCitizenOn20November2014 = new YesNo(driver,
					"quiz.childUSCitizenOn20November2014");
			childUSCitizenOn20November2014.setYesOrNo(childUScitizen);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

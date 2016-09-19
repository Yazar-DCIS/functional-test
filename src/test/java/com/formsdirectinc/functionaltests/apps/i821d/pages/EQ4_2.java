package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ4_2 extends WizardPage {

	private YesNo childUSGCHolderOn20November2014;

	public EQ4_2(WebDriver driver) {
		super(driver);
	}

	public EQ4_2 childUSGCHolderOn20November2014(String childUSGCholder)
			throws Exception {

		if (!childUSGCholder.equalsIgnoreCase("skip")) {
			childUSGCHolderOn20November2014 = new YesNo(driver,
					"quiz.childUSGCHolderOn20November2014");
			childUSGCHolderOn20November2014.setYesOrNo(childUSGCholder);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_1 extends WizardPage {

	private YesNo currentlyUndocumented;

	public EQ2_1(WebDriver driver) {
		super(driver);
	}

	public EQ2_1 currentlyUndocumented(String currentlyundocumented)
			throws Exception {
		if (!currentlyundocumented.equalsIgnoreCase("skip")) {
			currentlyUndocumented = new YesNo(driver,"quiz.currentlyUndocumented");
			currentlyUndocumented.setYesOrNo(currentlyundocumented);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

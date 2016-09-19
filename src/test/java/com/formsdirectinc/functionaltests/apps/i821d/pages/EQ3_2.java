package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_2 extends WizardPage {

	private YesNo currentlyInSchool;

	public EQ3_2(WebDriver driver) {
		super(driver);
	}

	public EQ3_2 currentlyInSchool(String schoolstatus) throws Exception {
		if (!schoolstatus.equalsIgnoreCase("skip")) {
			currentlyInSchool = new YesNo(driver, "quiz.currentlyInSchool");
			currentlyInSchool.setYesOrNo(schoolstatus);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

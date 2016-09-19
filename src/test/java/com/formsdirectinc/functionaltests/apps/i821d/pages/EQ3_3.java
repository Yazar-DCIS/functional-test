package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_3 extends WizardPage {

	private YesNo fromhighschool;

	public EQ3_3(WebDriver driver) {
		super(driver);
	}

	public EQ3_3 graduatedFromHighSchool(String schoolstatus) throws Exception {
		if (!schoolstatus.equalsIgnoreCase("skip")) {
			fromhighschool = new YesNo(driver, "quiz.graduatedFromHighSchool");
			fromhighschool.setYesOrNo(schoolstatus);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

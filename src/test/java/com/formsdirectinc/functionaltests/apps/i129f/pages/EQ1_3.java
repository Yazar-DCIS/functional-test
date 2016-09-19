package com.formsdirectinc.functionaltests.apps.i129f.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_3 extends WizardPage {
	public YesNo previousMarraige;

	public EQ1_3(WebDriver driver) {
		super(driver);
	}

	public EQ1_3 freeToMarry(String freeToMarryAndPreviousMarrigeTerminated)
			throws Exception {
		previousMarraige = new YesNo(driver, "quiz.freeToMarry");
		previousMarraige.setYesOrNo(freeToMarryAndPreviousMarrigeTerminated);
		saveScreenShot("i129f", "EQ1_3"); clickContinueInEQ();
		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {
	public YesNo enteringUS;

	public EQ1_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_2 marryWithIn90Days(String marryWithIn90DaysEnteringUS)
			throws Exception {
		enteringUS = new YesNo(driver, "quiz.marryWithin90Days");
		enteringUS.setYesOrNo(marryWithIn90DaysEnteringUS);
		saveScreenShot("i129f", "EQ1_2"); clickContinueInEQ();
		return this;
	}
}

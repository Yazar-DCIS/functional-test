package com.formsdirectinc.functionaltests.apps.i129f.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1 extends WizardPage {
	public YesNo usCitizen;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 usCitizen(String isUSCitizen) throws Exception {
		
		usCitizen = new YesNo(driver, "quiz.usCitizen");
		usCitizen.setYesOrNo(isUSCitizen);
		
		saveScreenShot("i129f", "EQ1_1"); clickContinueInEQ();
		return this;
	}
}
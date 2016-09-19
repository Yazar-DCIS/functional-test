package com.formsdirectinc.functionaltests.apps.i129f.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_4 extends WizardPage {
	public YesNo metFiance;

	public EQ1_4(WebDriver driver) {
		super(driver);
	}

	public EQ1_4 metFiance(String metFianceInLastTwoYears) {
		metFiance = new YesNo(driver, "quiz.metFiance");
		metFiance.setYesOrNo(metFianceInLastTwoYears);
		saveScreenShot("i129f", "EQ1_4"); clickContinueInEQ();
		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_4 extends WizardPage {

	public YesNo livingInUS;

	public EQ1_4(WebDriver driver) {
		super(driver);

	}

	public EQ1_4 spouseCurrentlyLivingInUS(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			livingInUS = new YesNo(driver, "quiz.spouseCurrentlyLivingInUS");
			livingInUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

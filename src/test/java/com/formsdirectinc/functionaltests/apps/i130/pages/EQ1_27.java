package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_27 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_27 extends WizardPage {

	public YesNo livingInUS;

	public EQ1_27(WebDriver driver) {
		super(driver);

	}

	public EQ1_27 legalPermanentResident(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			livingInUS = new YesNo(driver, "quiz.legalPermanentResident");
			livingInUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_23 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_23 extends WizardPage {

	public YesNo stepParentMarriedBP;

	public EQ1_23(WebDriver driver) {
		super(driver);

	}

	public EQ1_23 stepParentMarriedBP(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			stepParentMarriedBP = new YesNo(driver, "quiz.stepParentMarriedBP");
			stepParentMarriedBP.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

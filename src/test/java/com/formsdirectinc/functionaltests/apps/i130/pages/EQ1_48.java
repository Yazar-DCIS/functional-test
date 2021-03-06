package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_48 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_48 extends WizardPage {

	public YesNo siblingStepBrotherOrSister;

	public EQ1_48(WebDriver driver) {
		super(driver);

	}

	public EQ1_48 siblingStepBrotherOrSister(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			siblingStepBrotherOrSister = new YesNo(driver,
					"quiz.siblingStepBrotherOrSister");

			siblingStepBrotherOrSister.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

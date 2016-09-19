package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_10 extends WizardPage {

	public YesNo stepParent;

	public EQ1_10(WebDriver driver) {
		super(driver);

	}

	public EQ1_10 stepParent(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			stepParent = new YesNo(driver, "quiz.stepParent");
			stepParent.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

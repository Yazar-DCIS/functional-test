package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_12 extends WizardPage {

	public YesNo childAge;

	public EQ1_12(WebDriver driver) {
		super(driver);

	}

	public EQ1_12 childUnderTwentyOne(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			childAge = new YesNo(driver, "quiz.childUnderTwentyOne");
			childAge.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

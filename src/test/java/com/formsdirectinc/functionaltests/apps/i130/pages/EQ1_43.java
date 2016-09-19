package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_43 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_43 extends WizardPage {

	public YesNo atLeastTwentyOneYears;

	public EQ1_43(WebDriver driver) {
		super(driver);

	}

	public EQ1_43 atLeastTwentyOneYears(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			atLeastTwentyOneYears = new YesNo(driver,
					"quiz.atLeastTwentyOneYears");

			atLeastTwentyOneYears.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

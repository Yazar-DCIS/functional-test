package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_46 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_46 extends WizardPage {

	public YesNo halfBrotherOrHalfSister;

	public EQ1_46(WebDriver driver) {
		super(driver);

	}

	public EQ1_46 halfBrotherOrHalfSister(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
		
			halfBrotherOrHalfSister = new YesNo(driver,
					"quiz.halfBrotherOrHalfSister");

			halfBrotherOrHalfSister.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

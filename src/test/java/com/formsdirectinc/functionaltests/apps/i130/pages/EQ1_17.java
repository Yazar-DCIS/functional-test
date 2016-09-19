package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


public class EQ1_17 extends WizardPage {

	public YesNo parentAdoptedYou;

	public EQ1_17(WebDriver driver) {
		super(driver);

	}

	public EQ1_17 parentAdoptedYou(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			parentAdoptedYou = new YesNo(driver, "quiz.parentAdaptedYou");

			parentAdoptedYou.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_26_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_26_1 extends WizardPage {

	public YesNo entryInUS;

	public EQ1_26_1(WebDriver driver) {
		super(driver);

	}

	public EQ1_26_1 spouseInspectedLastEntryUS(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			entryInUS = new YesNo(driver, "quiz.spouseInspectedLastEntryUS");
			entryInUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

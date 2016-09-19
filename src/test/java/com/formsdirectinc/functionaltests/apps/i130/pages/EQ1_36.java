package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_36 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_36 extends WizardPage {

	public YesNo childBornBeforePR;

	public EQ1_36(WebDriver driver) {
		super(driver);

	}

	public EQ1_36 childBornBeforePR(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			childBornBeforePR = new YesNo(driver, "quiz.childBornBeforePR");
			childBornBeforePR.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

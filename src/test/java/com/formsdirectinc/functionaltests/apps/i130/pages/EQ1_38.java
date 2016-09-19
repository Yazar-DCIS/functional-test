package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_38 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_38 extends WizardPage {

	public YesNo childMarried;

	public EQ1_38(WebDriver driver) {
		super(driver);

	}

	public EQ1_38 childMarried(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			childMarried = new YesNo(driver, "quiz.childMarried");
			childMarried.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_21 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_21 extends WizardPage {

	public YesNo parentLivingInTheUS;

	public EQ1_21(WebDriver driver) {
		super(driver);

	}

	public EQ1_21 parentLivingInTheUS(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			parentLivingInTheUS = new YesNo(driver, "quiz.parentLivingInTheUS");
			parentLivingInTheUS.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_13 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_13 extends WizardPage {

	public YesNo childCurrentlyLivingInUS;

	public EQ1_13(WebDriver driver) {
		super(driver);

	}

	public EQ1_13 childCurrentlyLivingInUS(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			childCurrentlyLivingInUS = new YesNo(driver,
					"quiz.childCurrentlyLivingInUS");

			childCurrentlyLivingInUS.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

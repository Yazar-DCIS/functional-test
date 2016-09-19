package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_8 extends WizardPage {

	public YesNo childCurrentlyLivingInUS;

	public EQ1_8(WebDriver driver) {
		super(driver);

	}

	public EQ1_8 childCurrentlyLivingInUS(String answer, Properties data) {

		if (!answer.equalsIgnoreCase("NA")) {

			
			childCurrentlyLivingInUS = new YesNo(driver,
					"quiz.childCurrentlyLivingInUS");

			childCurrentlyLivingInUS.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

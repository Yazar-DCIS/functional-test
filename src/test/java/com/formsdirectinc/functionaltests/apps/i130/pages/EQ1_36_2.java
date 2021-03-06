package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_36_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_36_2 extends WizardPage {

	public YesNo livingInUS;

	public EQ1_36_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_36_2 applicantCurrentlyLivingInUS(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			livingInUS = new YesNo(driver, "quiz.applicantCurrentlyLivingInUS");
			livingInUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

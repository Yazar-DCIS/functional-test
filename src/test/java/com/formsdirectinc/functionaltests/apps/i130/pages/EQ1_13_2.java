package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_13_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_13_2 extends WizardPage {

	public MultiRadioOptions legalStatus;

	public EQ1_13_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_13_2 childLivingUSUnderLegalStatus(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			legalStatus = new MultiRadioOptions(driver,
					"applicationData-quiz.childLivingUSUnderLegalStatus");

			if (answer.equalsIgnoreCase("Yes")) {

				legalStatus.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("No")) {

				legalStatus.selectOption(2);
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

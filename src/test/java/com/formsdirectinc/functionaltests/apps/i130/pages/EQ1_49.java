package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_49 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_49 extends WizardPage {

	public YesNo parentsMarreidBeforeEighteenth;

	public EQ1_49(WebDriver driver) {
		super(driver);

	}

	public EQ1_49 parentsMarreidBeforeEighteenth(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			parentsMarreidBeforeEighteenth = new YesNo(driver,
					"quiz.parentsMarreidBeforeEighteenth");
			parentsMarreidBeforeEighteenth.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for EQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ2_3 extends WizardPage {

	private MultiRadioOptions whenenterus;

	public EQ2_3(WebDriver driver) {
		super(driver);
	}

	public EQ2_3 whenEnterUS(String whenEnterUS) throws Exception {
		if (!whenEnterUS.equalsIgnoreCase("skip")) {
			whenenterus = new MultiRadioOptions(driver,
					"applicationData-quiz.whenEnterUS");
			if (whenEnterUS.equalsIgnoreCase("beforeJune")) {
				whenenterus.selectOption(1);
			} else if (whenEnterUS.equalsIgnoreCase("OnJune16")) {
				whenenterus.selectOption(2);
			} else if (whenEnterUS.equalsIgnoreCase("OnJan1")) {
				whenenterus.selectOption(3);
			}
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

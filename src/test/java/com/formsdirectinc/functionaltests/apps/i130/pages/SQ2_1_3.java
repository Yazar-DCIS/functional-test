package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1_3 extends WizardPage {

	private YesNo fiveYearsPassedSinceLPR;

	public SQ2_1_3(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_3 permanentResidentYearCompletion(String completed5Year) {

		if (!completed5Year.equalsIgnoreCase("na")) {

			fiveYearsPassedSinceLPR = new YesNo(driver,
					"relative.fiveYearsPassedSinceLPR");
			fiveYearsPassedSinceLPR.setYesOrNo(completed5Year);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

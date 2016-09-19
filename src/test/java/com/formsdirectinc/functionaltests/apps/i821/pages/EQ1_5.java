package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_5 extends WizardPage {

	private YesNo country_status;

	public EQ1_5(WebDriver driver) {
		super(driver);
	}

	public EQ1_5 desiOrRedesiTpsCountry(String designation) {
		if (!designation.equalsIgnoreCase("NA")) {

			country_status = new YesNo(driver, "quiz.desiOrRedesiTpsCountry");
			country_status.setYesOrNo(designation);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;

	}

}

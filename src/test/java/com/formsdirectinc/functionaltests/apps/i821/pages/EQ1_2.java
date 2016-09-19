package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {

	public EQ1_2(WebDriver driver) {
		super(driver);
	}

	private AdditionalInfoFields selectDDM;

	public EQ1_2 tpsCountryCoc(String country) {
		if (!country.equalsIgnoreCase("NA")) {
			selectDDM = new AdditionalInfoFields(driver,
					"applicationData-quiz.tpsCountryCoc-country");
			selectDDM.selectDDM(country);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;

	}
}

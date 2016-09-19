package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_3 extends WizardPage {

	public EQ1_3(WebDriver driver) {
		super(driver);
	}

	private AdditionalInfoFields selectDDM;

	public EQ1_3 tpsCountryCor(String country_cor) {
		if (!country_cor.equalsIgnoreCase("NA")) {
			selectDDM = new AdditionalInfoFields(driver,
					"applicationData-quiz.tpsCountryCor-country");
			selectDDM.selectDDM(country_cor);

			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_2_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_10 extends WizardPage {

	private MultiRadioOptions relative;

	public SQ2_2_10(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_10 applyingForBiologicalParents(String relation) {

		if (!relation.equalsIgnoreCase("na")) {
			relative = new MultiRadioOptions(driver,
					"applicationData-relative.applyingForBiologicalParents");

			if (relation.equalsIgnoreCase("Father")) {
				relative.selectOption(1);
			}

			else if (relation.equalsIgnoreCase("Mother")) {
				relative.selectOption(2);
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

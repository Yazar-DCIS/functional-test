package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1_1 extends WizardPage {

	private MultiRadioOptions relative;

	public SQ2_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_1 applicantFamilyRelationType(String relation) {

		if (!relation.equalsIgnoreCase("na")) {
			relative = new MultiRadioOptions(driver,
					"applicationData-relative.familyRelation");

			if (relation.equalsIgnoreCase("Spouse")) {
				relative.selectOption(1);
			}

			else if (relation.equalsIgnoreCase("Child")) {
				relative.selectOption(2);
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

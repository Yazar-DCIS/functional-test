package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_1_1 extends WizardPage {

	private MultiRadioOptions relative;

	public SQ2_2_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_1_1 siblingRelation(String relation) {

		if (!relation.equalsIgnoreCase("na")) {

			relative = new MultiRadioOptions(driver,
					"applicationData-relative.siblingRelation");

			if (relation.equalsIgnoreCase("Siblings")) {
				relative.selectOption(1);
			}

			else if (relation.equalsIgnoreCase("HalfSiblings")) {
				relative.selectOption(2);
			}
			else if (relation.equalsIgnoreCase("StepSiblings")) {
				relative.selectOption(3);
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1_1 extends WizardPage {

	private MultiRadioOptions selectRelation;

	public SQ2_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_1 relationToTheUser(String relation) {

		if (!relation.equalsIgnoreCase("NA")) {

			selectRelation = new MultiRadioOptions(driver,
					"applicationData-applicant.eligibility.applyingOnBehalf");

			if (relation.equalsIgnoreCase("ADOP_CHILD")) {
				selectRelation.selectOption(2);
			}
			else if (relation.equalsIgnoreCase("BIO_CHILD")) {
				selectRelation.selectOption(1);
			}
			saveScreenShot("n600", "SQ2_1_1"); clickContinueInSQ();

		}
		return this;
	}

}

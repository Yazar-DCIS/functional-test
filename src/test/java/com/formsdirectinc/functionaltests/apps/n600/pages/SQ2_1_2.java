package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1_2 extends WizardPage {

	private MultiRadioOptions selectRelation;

	public SQ2_1_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_2 relationToTheUser(String relation) {

		if (!relation.equalsIgnoreCase("NA")) {

			selectRelation = new MultiRadioOptions(driver,
					"applicationData-applicant.eligibility.otherApplicantRelationship");

			if (relation.equalsIgnoreCase("FATHER")) {
				selectRelation.selectOption(1);
			}

			else if (relation.equalsIgnoreCase("MOTHER")) {
				selectRelation.selectOption(2);
			}

			saveScreenShot("n600", "SQ2_1_2"); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	private MultiRadioOptions eligibleRelation;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2 relationToTheUser(String relation) {

		if (!relation.equalsIgnoreCase("NA")) {

			eligibleRelation = new MultiRadioOptions(driver,
					"applicationData-applicant.eligibility.applicantClaimingUSCitizenship");

			if (relation.equalsIgnoreCase("User_BIO_FATHER")) {
				eligibleRelation.selectOption(1);
			}

			else if (relation.equalsIgnoreCase("User_BIO_MOTHER")) {
				eligibleRelation.selectOption(2);
			}

			else if (relation.equalsIgnoreCase("User_BIO_PARENTS")) {
				eligibleRelation.selectOption(3);
			}

			else if (relation.equalsIgnoreCase("User_ADOP_FATHER")) {
				eligibleRelation.selectOption(4);
			}

			else if (relation.equalsIgnoreCase("User_ADOP_MOTHER")) {
				eligibleRelation.selectOption(5);
			}

			else if (relation.equalsIgnoreCase("User_ADOP_PARENTS")) {
				eligibleRelation.selectOption(6);
			}
			saveScreenShot("n600", "SQ2_2"); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private MultiRadioOptions selectRelation;
	private YesNo claimCitizenship, armedForces;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1 relationToTheUser(String relation) {

		if (!relation.equalsIgnoreCase("NA")) {

			selectRelation = new MultiRadioOptions(driver,
					"applicationData-applicant.eligibility.applicantRelationship");

			if (relation.equalsIgnoreCase("USER")) {
				selectRelation.selectOption(1);
			}
			else if (relation.equalsIgnoreCase("BIO_FATHER")) {
				selectRelation.selectOption(2);
			}
			else if (relation.equalsIgnoreCase("BIO_MOTHER")) {
				selectRelation.selectOption(3);

			}
			else if (relation.equalsIgnoreCase("ADOP_FATHER")) {
				selectRelation.selectOption(4);
			}
			else if (relation.equalsIgnoreCase("ADOP_MOTHER")) {
				selectRelation.selectOption(5);
			}
			else if (relation.equalsIgnoreCase("NATIONAL")) {
				selectRelation.selectOption(6);
			}
			else if (relation.equalsIgnoreCase("None")) {
				selectRelation.selectOption(7);
			}

		}
		return this;

	}

	public SQ2_1 claimCitizenship(String claim) {

		if (!claim.equalsIgnoreCase("NA")) {
			claimCitizenship = new YesNo(driver,
					"applicant.eligibility.claimCitizenshipAtBirth");
			claimCitizenship.setYesOrNo(claim);
		}
		return this;

	}

	public SQ2_1 armedForces(String service) {
		if (!service.equalsIgnoreCase("NA")) {
			armedForces = new YesNo(driver,
					"applicant.additionalInfo.memberArmedForce");
			armedForces.setYesOrNo(service);
			saveScreenShot("n600", "SQ2_1"); clickContinueInSQ();
		}
		return this;

	}

}

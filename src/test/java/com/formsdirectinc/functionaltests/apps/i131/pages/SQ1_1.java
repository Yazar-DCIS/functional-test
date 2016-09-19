package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_1 extends WizardPage {
	private MultiRadioOptions selectReason, travelReason;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 selectReason(String reason) {
		if (!reason.equalsIgnoreCase("NA")) {
			
			selectReason = new MultiRadioOptions(driver,
					"applicationData-applicant.reasonForApplying");

			if (reason.equalsIgnoreCase("ReEntryPermit")) {
				selectReason.selectOption(1);
			}
			else if (reason.equalsIgnoreCase("RefugeeTravelDocument")) {
				selectReason.selectOption(2);
			}
			else if (reason.equalsIgnoreCase("PermanantResidentRefugee")) {
				selectReason.selectOption(3);
			}
			else if (reason.equalsIgnoreCase("PendingI485")) {
				selectReason.selectOption(4);
			}
			else if (reason.equalsIgnoreCase("ApprovedI821")) {
				selectReason.selectOption(5);
			}
			else if (reason.equalsIgnoreCase("PendingI821")) {
				selectReason.selectOption(6);
			}
			else if (reason.equalsIgnoreCase("ApprovedI821D")) {
				selectReason.selectOption(7);
				travelReason = new MultiRadioOptions(driver,
						"applicationData-applicant.purposeOfProposedTravel");
				travelReason.selectOption(1);
			}
			else if (reason.equalsIgnoreCase("Others")) {
				selectReason.selectOption(8);
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
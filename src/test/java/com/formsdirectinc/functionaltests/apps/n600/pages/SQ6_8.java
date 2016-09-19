package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_8 extends WizardPage {

	protected MultiRadioOptions immigrationStatus;
	protected AdditionalInfoFields otherStatus;

	public SQ6_8(WebDriver driver) {
		super(driver);

	}

	public SQ6_8 motherImmigrationStatus(String immigrationType) {

		if (!immigrationType.equalsIgnoreCase("NA")) {

			immigrationStatus = new MultiRadioOptions(
					driver,

					"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.immigrationStatus");

			if (immigrationType.equalsIgnoreCase("USCitizen")) {
				immigrationStatus.selectOption(1);
			}

			else if (immigrationType.equalsIgnoreCase("PermanentResident")) {
				immigrationStatus.selectOption(2);
			}

			else if (immigrationType.equalsIgnoreCase("Other")) {
				immigrationStatus.selectOption(3);
				otherStatus = new AdditionalInfoFields(
						driver,

						"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.otherImmigrationStatus");
				otherStatus.isStatusOther("explain");
			}
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

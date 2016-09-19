package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	private AdditionalInfoFields maritalStatus, explainStatus;

	public SQ3_2(WebDriver driver) {
		super(driver);

	}

	public SQ3_2 setMaritalStatus(Properties data, String maritalCount) {

		if (!maritalCount.equalsIgnoreCase("NA")) {
			maritalStatus = new AdditionalInfoFields(driver,
					"applicationData-applicant.additionalInfo.maritalStatus.status");

			if (maritalCount.equalsIgnoreCase("Single")) {
				maritalStatus.selectDDM(data.getProperty("status_Single"));
			}

			else if (maritalCount.equalsIgnoreCase("Married")) {
				maritalStatus.selectDDM(data.getProperty("status_Married"));

			}

			else if (maritalCount.equalsIgnoreCase("Other")) {
				maritalStatus.selectDDM(data.getProperty("status_Other"));

				explainStatus = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.maritalStatusOtherExplanation");
				explainStatus.isStatusOther(data.getProperty("Reasons"));

			}

			else if (maritalCount.equalsIgnoreCase("Widowed")) {
				maritalStatus.selectDDM(data.getProperty("status_Widowed"));
			}

			else if (maritalCount.equalsIgnoreCase("Divorced")) {
				maritalStatus.selectDDM(data.getProperty("status_Divorced"));
			}

			else if (maritalCount.equalsIgnoreCase("Annulled")) {
				maritalStatus.selectDDM(data.getProperty("status_Annulled"));
			}

			saveScreenShot("n600", "SQ3_2"); clickContinueInSQ();
		}
		return this;
	}

}

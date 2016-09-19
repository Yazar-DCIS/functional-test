package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	private AdditionalInfoFields maritalStatus;

	public SQ3_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_1 maritalStatus(Properties copies, Properties data,
			String maritalStatusAnswer) {

		if (!maritalStatusAnswer.equalsIgnoreCase("NA")) {

			maritalStatus = new AdditionalInfoFields(driver,
					"applicationData-applicant.maritalStatus-status");

			if (maritalStatusAnswer.equalsIgnoreCase("Single")) {
				maritalStatus.selectDDM(data.getProperty("status_Single"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Married")) {
				maritalStatus.selectDDM(data.getProperty("status_Married"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Separated")) {
				maritalStatus.selectDDM(data.getProperty("status_Separated"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Widowed")) {
				maritalStatus.selectDDM(data.getProperty("status_Widowed"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Divorced")) {
				maritalStatus.selectDDM(data.getProperty("status_Divorced"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Annulled")) {
				maritalStatus.selectDDM(data.getProperty("status_Annulled"));
			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_1");
			
			 clickContinueInSQ();
		}
		return this;
	}

}

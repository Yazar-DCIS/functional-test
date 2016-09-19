package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_9 extends WizardPage {

	private MaritalInfo maritalStatus;

	public SQ2_9(WebDriver driver) {
		super(driver);

	}

	public SQ2_9 relativeMaritalStatus(Properties data, String maritalStatusAnswer) {
		if (!maritalStatusAnswer.equalsIgnoreCase("na")) {
			maritalStatus = new MaritalInfo(driver,
					"applicationData-relative.maritalStatus");

			if (maritalStatusAnswer.equalsIgnoreCase("Single")) {
				maritalStatus.setMarriageStatus(data
						.getProperty("status_Single"));
			}
			else if (maritalStatusAnswer.equalsIgnoreCase("Married")) {
				maritalStatus.setMarriageStatus(data
						.getProperty("status_Married"));
			}
			else if (maritalStatusAnswer.equalsIgnoreCase("Widowed")) {
				maritalStatus.setMarriageStatus(data
						.getProperty("status_Widowed"));
			}

			else if (maritalStatusAnswer.equalsIgnoreCase("Divorced")) {
				maritalStatus.setMarriageStatus(data
						.getProperty("status_Divorced"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

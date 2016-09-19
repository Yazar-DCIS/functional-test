package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_4 extends WizardPage {

	private MaritalInfo maritalStatus;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 applicantMaritalStatus(Properties data) {
		maritalStatus = new MaritalInfo(driver,
				"applicationData-applicant.maritalStatus");
		maritalStatus.setMarriageStatus(data.getProperty("maritalStatus"));

		return this;
	}

}

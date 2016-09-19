package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {
	private MaritalInfo maritalStatus;

	public SQ2_6(WebDriver driver) {
		super(driver);

	}

	public SQ2_6 applicantMarritalStatus(Properties data) throws Exception {
		maritalStatus = new MaritalInfo(driver,
				"applicationData-applicant.maritalStatus");
		maritalStatus.setMarriageStatus(data.getProperty("maritalStatus"));

		return this;

	}

}

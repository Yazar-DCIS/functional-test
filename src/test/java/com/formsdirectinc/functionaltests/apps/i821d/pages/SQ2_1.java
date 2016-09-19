package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	private Name_FirstMiddleLast applicantName;

	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1 applicantNameDetails(Properties data) throws Exception {

		applicantName = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");// applicationData-applicant.name-first
		applicantName.setFirstNameField(data.getProperty("FirstName0"));
		applicantName.setLastNameField(data.getProperty("LastName"));

		return this;
	}

}

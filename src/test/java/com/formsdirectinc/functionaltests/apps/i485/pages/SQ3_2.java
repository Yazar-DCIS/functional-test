package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	private AdditionalInfoFields lastEntryStatus, immigrationStatus;
	private CheckBox validCheck;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 admissionCurrentStatus(Properties data) {

		lastEntryStatus = new AdditionalInfoFields(driver,
				"applicationData-applicant.mannerOfEntry");
		lastEntryStatus.textDDM(data.getProperty("entryStatus"));

		immigrationStatus = new AdditionalInfoFields(driver,
				"applicationData-applicant.currentImmigrationStatus");
		immigrationStatus.normalText(data.getProperty("entryStatus"));

		validCheck = new CheckBox(driver, "applicationData-applicant.statusI94");
		validCheck.check();
		return this;
	}

}

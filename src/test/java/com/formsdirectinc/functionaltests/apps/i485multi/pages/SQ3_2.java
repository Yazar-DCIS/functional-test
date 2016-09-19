package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	
	

	private AdditionalInfoFields classOfAdmission;
	private CheckBox cardStatus;

	public SQ3_2(WebDriver driver) {
		super(driver);

	}

	public void classOfAdmission(Properties data,String applicanttype) {

		classOfAdmission = new AdditionalInfoFields(driver,
				"applicationData-"+applicanttype+"Applicant.immigrationStatus.mannerOfEntry");
		classOfAdmission.textDDM(data.getProperty("COAdmission"));

		classOfAdmission = new AdditionalInfoFields(driver,
				"applicationData-"+applicanttype+"Applicant.immigrationStatus.currentImmigrationStatus");
		classOfAdmission.normalText(data.getProperty("COAdmission"));

		cardStatus = new CheckBox(driver,
				"applicationData-"+applicanttype+"Applicant.immigrationStatus.statusI94");
		cardStatus.check();

	}

	
}

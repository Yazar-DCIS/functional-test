package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {

	private AdditionalInfoFields mail;
	private CommonInputClasses phone_No;
	private YesNo notify;

	public SQ2_7(WebDriver driver) {
		super(driver);
	}

	public void set_Email(Properties data) {
		mail = new AdditionalInfoFields(driver,
				"applicationData-applicant.homeAddress.email");
		mail.normalText(data.getProperty("Mail"));

	}

	public void set_cellPhoneNo(Properties data) {
		phone_No = new CommonInputClasses(driver);
		phone_No.applicantNumberDetails(
				"applicationData-applicant.cellPhonePrimary", data);
	}

	public void set_dayPhoneNo(Properties data) {
		phone_No = new CommonInputClasses(driver);
		phone_No.applicantNumberDetails(
				"applicationData-applicant.homeAddress.dayPhone", data);
	}

	public void set_EmailUpdates(Properties data) {
		mail = new AdditionalInfoFields(driver,
				"applicationData-applicant.contactMethods.email");
		mail.normalText(data.getProperty("Mail"));

	}

	public void set_dayPhoneUpdates(Properties data) {
		phone_No = new CommonInputClasses(driver);
		phone_No.applicantNumberDetails(
				"applicationData-applicant.contactMethods", data);
	}

	public void set_notifications() {
		notify = new YesNo(driver, "applicant.wantToReceiveUscisEmail");
		notify.no();
	}

}

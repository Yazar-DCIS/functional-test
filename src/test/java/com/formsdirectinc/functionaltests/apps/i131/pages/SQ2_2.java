package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {
	private PhoneNumber mobileNo;
	private EMailAddress email;

	private YesNo notifications;

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_2 contactInformation(Properties data) {

		email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		// id changes
		email.setEMail(data.getProperty("Mail"));

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		// id changes
		mobileNo = new PhoneNumber(driver,
				"applicationData-applicant.cellPhoneNumber");
		mobileNo.setPhoneCode(data.getProperty("Phone1"));
		mobileNo.setPhoneNumber(data.getProperty("Phone2"));

		notifications = new YesNo(driver, "applicant.receiveTextOrMail");
		notifications.yes();

		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

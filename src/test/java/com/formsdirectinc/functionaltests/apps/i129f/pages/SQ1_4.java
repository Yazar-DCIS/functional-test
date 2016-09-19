package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4 extends WizardPage {
	private PhoneNumber contactNumber;
	private EMailAddress email;

	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_4 contactInformation(Properties data) {

		contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		email.setEMail(data.getProperty("Mail"));

		YesNo receiveNotifications=new YesNo(driver, "applicant.notificationRequired");
		receiveNotifications.no();
		
		saveScreenShot("i129f", "SQ1_4"); clickContinueInSQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_3 extends WizardPage {

	
	

	
	private YesNo notify;

	public SQ4_3(WebDriver driver) {
		super(driver);

	}

	public void applicantNumberDetails(Properties data) {

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.phoneExtention");
		contactNumber.setPhoneCode(data.getProperty("Phone1"));
		contactNumber.setPhoneNumber(data.getProperty("Phone2"));

		notify = new YesNo(driver, "applicant.mailNotification");
		notify.no();

	}

}

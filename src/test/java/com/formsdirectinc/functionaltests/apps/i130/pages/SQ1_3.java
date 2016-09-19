package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {

	private YesNo notify;

	public SQ1_3(WebDriver driver) {
		super(driver);

	}

	public void applicantPhoneNumber(Properties data, String needNotifications) {

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		notify = new YesNo(driver, "applicant.wantToReceiveUscisEmail");
		notify.setYesOrNo(needNotifications);

		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
	}

}

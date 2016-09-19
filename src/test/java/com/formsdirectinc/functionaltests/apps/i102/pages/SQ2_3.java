package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_3 extends WizardPage {

	private PhoneNumber contactNumber;
	private YesNo notify;

	public SQ2_3(WebDriver driver) {
		super(driver);

	}

	public SQ2_3 setNumberFields(Properties data, String notification) {

		contactNumber = new PhoneNumber(driver,
				"applicationData-applicantInfo.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		notify = new YesNo(driver, "eligibilityInfo.notification");
		notify.setYesOrNo(notification);

		saveScreenShot("I102", "SQ2_3"); clickContinueInSQ();

		return this;

	}

}

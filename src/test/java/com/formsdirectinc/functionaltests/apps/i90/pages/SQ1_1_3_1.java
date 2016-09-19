package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;
/**
 * I-90: Contact Information
 * @author Orina
 * Revision: $Rev$
 */


public class SQ1_1_3_1 extends WizardPage {

	private YesNo receiveNotifications;

	public SQ1_1_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_3_1 contactDetails(Properties data,String requireNotifications) {
			
			receiveNotifications = new YesNo(driver,
					"formSpecific.wishToReceiveEmailNotification");

			receiveNotifications.setYesOrNo(requireNotifications);

			PhoneNumber contactNumber = new PhoneNumber(driver,	"applicationData-applicant.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("applicant.contactMethods.dayphone1"),
					data.getProperty("applicant.contactMethods.dayphone2"));

			contactNumber.setEveningTimeNumber(data.getProperty("applicant.contactMethods.eveningphone1"),
					data.getProperty("applicant.contactMethods.eveningphone2"));

			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

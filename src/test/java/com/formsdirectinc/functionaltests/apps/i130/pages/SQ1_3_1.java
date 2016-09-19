package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3_1 extends WizardPage {

	public SQ1_3_1(WebDriver driver) {
		super(driver);
	}

	public void applicantUSCISNotfication(Properties data) {
		PhoneNumber cellNo = new PhoneNumber(driver,
				"applicationData-applicant.cellPhoneNumber");
		cellNo.setPhoneCode(data.getProperty("Phone1"));
		cellNo.setPhoneNumber(data.getProperty("Phone2"));

		EMailAddress email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		email.setEMail(data.getProperty("Mail"));

		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();

	}

}

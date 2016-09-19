package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_4_0 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4_0 extends WizardPage {

	public SQ1_4_0(WebDriver driver) {
		super(driver);
	}

	public SQ1_4_0 applicantUSCISNotfication(Properties data) throws Exception {
		
		PhoneNumber cellNo = new PhoneNumber(driver,
				"applicationData-formSpecific.mobileNumber");
		cellNo.setPhoneCode(data.getProperty("Phone1"));
		cellNo.setPhoneNumber(data.getProperty("Phone2"));

		EMailAddress email = new EMailAddress(driver,
				"applicationData-applicant.homeAddress");
		email.setEMail(data.getProperty("Mail"));

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	private Address applicantAddress;
	private YesNo notify;

	public SQ2_3(WebDriver driver) {
		super(driver);

	}

	public SQ2_3 applicantAddress(Properties data) throws Exception {

		applicantAddress = new Address(driver,
				"applicationData-applicant.mailingAddress");
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setState(data.getProperty("State"));
		applicantAddress.setZipcode(data.getProperty("Zipcode"));

		notify = new YesNo(driver, "applicant.sameAddress");
		notify.yes();

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		// e-mail address
		EMailAddress email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		email.setEMail(data.getProperty("Mail"));

		notify = new YesNo(driver, "applicant.uscisNotification");
		notify.yes();

		notify = new YesNo(driver, "applicant.mailingAddress.hasInCareOfAgent");
		notify.no();
		return this;

	}
}

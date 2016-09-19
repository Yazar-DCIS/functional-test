package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_6 extends WizardPage {

	private CommonInputClasses address;
	private YesNo mailingAddress;

	public SQ2_6(WebDriver driver) {
		super(driver);
	}

	public void set_Current_Address(Properties data) {
		address = new CommonInputClasses(driver);
		address.applicantAddressDetails(
				"applicationData-applicant.currentAddress", data);

	}

	public void set_MailingAddress() {
		mailingAddress = new YesNo(driver, "applicant.alsoMailingAddress");
		mailingAddress.yes();
	}

	public void set_MailingAddressCareOf() {

		mailingAddress = new YesNo(driver, "applicant.wantMailingAddressCareOf");
		mailingAddress.no();
	}

	public void set_homeAddressInCareOf() {
		mailingAddress = new YesNo(driver,
				"applicant.homeAddressInCareOf.hasInCareOfAgent");
		mailingAddress.no();
	}

	public void set_homeAddress(Properties data) {
		address = new CommonInputClasses(driver);
		address.applicantAddressDetails(
				"applicationData-applicant.homeAddress", data);
	}

	public void set_homeAddressUpdates(Properties data) {
		address = new CommonInputClasses(driver);
		address.applicantAddressDetails(
				"applicationData-applicant.homeAddressInCareOf", data);
	}
}

package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {

	private YesNo notify;
	private Address addressDetails;

	public SQ1_3(WebDriver driver) {
		super(driver);

	}

	public SQ1_3 addressDetails(Properties data) throws Exception {

		addressDetails = new Address(driver,
				"applicationData-applicant.homeAddress");
		addressDetails.setStreet(data.getProperty("StreetName"));
		addressDetails.setCity(data.getProperty("City765"));
		addressDetails.setState(data.getProperty("State"));
		addressDetails.setZipcode(data.getProperty("Zipcode"));

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
				data.getProperty("Phone2"));

		notify = new YesNo(driver, "applicant.acceptedForProcessing");
		notify.no();

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

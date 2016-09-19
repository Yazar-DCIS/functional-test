package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {
	private Address usAddress;
	private YesNo careOf;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public SQ2_3 addressDetails(Properties data) {

		
		usAddress = new Address(driver, "applicationData-applicant.usAddress");
		// usAddress.setCareOfName(data.getProperty("CareOfName"));
		usAddress.setStreet(data.getProperty("Mail_Street"));
		usAddress.setCity(data.getProperty("I131_City"));
		usAddress.setState(data.getProperty("Mail_State"));
		usAddress.setZipcode(data.getProperty("Mail_Zipcode"));

		// new control

		careOf = new YesNo(driver, "applicant.usAddress.hasInCareOfAgent");
		careOf.no();

		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

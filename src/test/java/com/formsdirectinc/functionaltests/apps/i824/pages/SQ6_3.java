package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_3 extends WizardPage {

	
	

	public SQ6_3(WebDriver driver) {
		super(driver);

	}

	public void beneficiaryNumberDetails(Properties data) {

		PhoneNumber contactNumber = new PhoneNumber(driver,
				"applicationData-beneficiary.phoneExtention");
		contactNumber.setPhoneCode(data.getProperty("Phone1"));
		contactNumber.setPhoneNumber(data.getProperty("Phone2"));

	}

}

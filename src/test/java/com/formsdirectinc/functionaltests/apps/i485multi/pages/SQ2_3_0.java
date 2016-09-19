package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_3_0 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_3_0 extends WizardPage {

	public SQ2_3_0(WebDriver driver) {
		super(driver);

	}

	public void optionalContactInformation(Properties data) {

		PhoneNumber applicantNumber = new PhoneNumber(driver,
				"applicationData-principalApplicant.cellPhoneNumber");
		applicantNumber.setPhoneCode(data.getProperty("Phone1"));
		applicantNumber.setPhoneNumber(data.getProperty("Phone2"));

	}

}

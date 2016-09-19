package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_6 extends WizardPage {

	private Numbers securityNumber;
	private YesNo haveSSN;

	public SQ2_6(WebDriver driver) {
		super(driver);

	}

	public SQ2_6 haveSSN(Properties data, String haveSSNumber) {

		haveSSN = new YesNo(driver, "applicantInfo.haveSSN");

		if (haveSSNumber.equalsIgnoreCase("Yes")) {

			haveSSN.yes();
			securityNumber = new Numbers(driver,
					"applicationData-applicantInfo.SSN");
			securityNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
					data.getProperty("SSN_2"), data.getProperty("SSN_3"));

		}
		else if (haveSSNumber.equalsIgnoreCase("No")) {
			haveSSN.no();
		}
		saveScreenShot("I102", "SQ2_6"); clickContinueInSQ();
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6 extends WizardPage {
	private YesNo haveSSNumber;
	private Numbers ssn;

	public SQ1_6(WebDriver driver) {
		super(driver);
	}

	public SQ1_6 socialSecurityNumber(Properties data, String haveSSN) {

		haveSSNumber = new YesNo(driver, "applicant.haveSSN");
		if (haveSSN.equalsIgnoreCase("Yes")) {

			haveSSNumber.yes();
			ssn = new Numbers(driver,"applicationData-applicant.SSN");
			ssn.setSocialSecurityNumber(data.getProperty("SSN_1"), data.getProperty("SSN_2"), data.getProperty("SSN_3"));
					
		}
		else if (haveSSN.equalsIgnoreCase("No")) {
			haveSSNumber.no();
		}
		saveScreenShot("i129f", "SQ1_6"); clickContinueInSQ();
		return this;
	}
}
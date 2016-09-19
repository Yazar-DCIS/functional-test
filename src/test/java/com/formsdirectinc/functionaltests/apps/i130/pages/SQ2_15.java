package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_15 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_15 extends WizardPage {

	private Numbers socialNumber;
	private YesNo ssn;

	public SQ2_15(WebDriver driver) {
		super(driver);

	}

	public SQ2_15 relativeSSN_Details(String haveSSN, Properties data) {

		if (haveSSN.equalsIgnoreCase("yes")||haveSSN.equalsIgnoreCase("no")) {
			ssn = new YesNo(driver, "relative.hasSSN");

			if (haveSSN.equalsIgnoreCase("Yes")) {
				ssn.yes();
				socialNumber = new Numbers(driver,
						"applicationData-relative.SSN");
				socialNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
						data.getProperty("SSN_2"), data.getProperty("SSN_3"));
			}

			else if (haveSSN.equalsIgnoreCase("No")) {
				ssn.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

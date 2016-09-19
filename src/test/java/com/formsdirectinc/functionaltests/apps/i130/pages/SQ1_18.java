package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_18 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_18 extends WizardPage {

	private Numbers socialNumber;
	private YesNo ssn;

	public SQ1_18(WebDriver driver) {
		super(driver);

	}

	public SQ1_18 applicantSSN_Details(String haveSSNAnswer, Properties data) {

		if (!haveSSNAnswer.equalsIgnoreCase("na")) {

			ssn = new YesNo(driver, "applicant.hasSSN");

			if (haveSSNAnswer.equalsIgnoreCase("Yes")) {
				ssn.yes();
				socialNumber = new Numbers(driver,
						"applicationData-applicant.SSN");
				socialNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
						data.getProperty("SSN_2"), data.getProperty("SSN_3"));

			}

			else if (haveSSNAnswer.equalsIgnoreCase("No")) {
				ssn.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_5 extends WizardPage {
	private YesNo haveSSNNumber;
	private CommonInputClasses ssn;

	public SQ2_5(WebDriver driver) {
		super(driver);
	}

	public SQ2_5 fianceSSN(Properties data, String fianceHaveSSN) {

		
		haveSSNNumber = new YesNo(driver, "foreignFiance.haveSSNNumber");
		if (fianceHaveSSN.equalsIgnoreCase("Yes")) {
			haveSSNNumber.yes();

			ssn = new CommonInputClasses(driver);
			ssn.applicantSSNDetails("applicationData-foreignFiance.SSN", data);
		}
		else if (fianceHaveSSN.equalsIgnoreCase("No")) {
			haveSSNNumber.no();
		}
		saveScreenShot("i129f", "SQ2_5"); clickContinueInSQ();
		return this;
	}
}
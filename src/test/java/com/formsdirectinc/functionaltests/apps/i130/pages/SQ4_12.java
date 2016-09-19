package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_12 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_12 extends WizardPage {

	private Numbers socialNumber;
	private YesNo ssn;

	public SQ4_12(WebDriver driver) {
		super(driver);

	}

	public SQ4_12 spouseSSN_Details(String haveSSN, Properties data) {

		if (haveSSN.equalsIgnoreCase("no")||haveSSN.equalsIgnoreCase("yes")) {
			ssn = new YesNo(driver, "spouseInfo.hasSSN");
			ssn.setYesOrNo(haveSSN);
			if (haveSSN.equalsIgnoreCase("Yes")) {
			
				socialNumber = new Numbers(driver,
						"applicationData-spouseInfo.SSN");
				socialNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
						data.getProperty("SSN_2"), data.getProperty("SSN_3"));
			}

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

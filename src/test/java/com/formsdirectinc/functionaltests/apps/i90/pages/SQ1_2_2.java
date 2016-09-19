package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90:Social Security Number
 * @author Orina
 */

public class SQ1_2_2 extends WizardPage {

	
	public SQ1_2_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2_2 socialSecurityNumber(Properties data, String haveSSN) {

		Numbers securityNumber = new Numbers(driver, "applicationData-applicant.SSN");
		
		if(haveSSN.equalsIgnoreCase("yes"))
		{
			securityNumber.setSocialSecurityNumber(data.getProperty("applicant.SSN.ssn1"),
					data.getProperty("applicant.SSN.ssn3"), 
					data.getProperty("applicant.SSN.ssn3"));
		}
		
		else if(haveSSN.equalsIgnoreCase("no"))
		{
			securityNumber.setNumberUnknown();
		}
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

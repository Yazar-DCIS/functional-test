package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ2_5 extends WizardPage {

	
	
	private AdditionalInfoFields number1, number2, number3;
	private YesNo haveSSN;

	public SQ2_5(WebDriver driver) {
		super(driver);

	}

	public void haveSSN(Properties data) {
		haveSSN = new YesNo(driver, "applicant.haveSSN");
		haveSSN.yes();
		number1 = new AdditionalInfoFields(driver,
				"applicationData-applicant.SSN-ssn1");
		number1.isStatusOther(data.getProperty("SSN_1"));
		number2 = new AdditionalInfoFields(driver,
				"applicationData-applicant.SSN-ssn2");
		number2.isStatusOther(data.getProperty("SSN_2"));
		number3 = new AdditionalInfoFields(driver,
				"applicationData-applicant.SSN-ssn3");
		number3.isStatusOther(data.getProperty("SSN_3"));

	}

	public void dontHaveSSN(Properties data) {
		haveSSN = new YesNo(driver, "formSpecific.hasSSN");
		haveSSN.no();

	}

}

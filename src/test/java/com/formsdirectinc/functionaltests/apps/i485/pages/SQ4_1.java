package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	private AdditionalInfoFields visaNumber;
	private DateTag visaDate;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 nonImmigrantVisaNumber(Properties data) {

		visaNumber = new AdditionalInfoFields(driver,
				"applicationData-applicant.nonimmigrantVisaNumber");
		visaNumber.normalText(data.getProperty("visaNumber"));

		visaDate = new DateTag(driver, "applicant.dateVisaIssued");
		visaDate.selectDate(data.getProperty("DOE"));

		return this;
	}

}

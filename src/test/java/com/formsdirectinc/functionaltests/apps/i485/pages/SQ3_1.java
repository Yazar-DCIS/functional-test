package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_1 extends WizardPage {

	private Address addressFields;
	private DateTag dateOfEntry;
	private YesNo arrivalDeparture;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public void setentryDate(Properties data) {
		dateOfEntry = new DateTag(driver, "applicant.dateOfEntry");
		dateOfEntry.selectDate(data.getProperty("DOE"));
	}

	public void setAddress(Properties data) {
		addressFields = new Address(driver,
				"applicationData-applicant.placeOfEntry");
		addressFields.setCity(data.getProperty("City"));
		addressFields = new Address(driver,
				"applicationData-applicant.placeOfEntry");
		addressFields.setBirthState(data.getProperty("State"));
	}

	public void noEmployment(Properties data) {
		arrivalDeparture = new YesNo(driver, "applicant.haveI94Number");
		arrivalDeparture.no();
	}

}
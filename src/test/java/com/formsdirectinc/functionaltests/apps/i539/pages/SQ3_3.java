package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_3 extends WizardPage {

	private DateTag lastEntered;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public void set_LastEnteredOn(Properties data) {
		lastEntered = new DateTag(driver, "applicant.lastEnteredOn");
		lastEntered.selectDate(data.getProperty("DOE"));

	}

}

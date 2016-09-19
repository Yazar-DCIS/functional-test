package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_1 extends WizardPage {

	private DateTag statusExpOn;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public void set_StatusExpireOn(Properties data) {
		statusExpOn = new DateTag(driver, "applicant.statusExpireOn");
		statusExpOn.selectDate(data.getProperty("DOExp"));

	}

}

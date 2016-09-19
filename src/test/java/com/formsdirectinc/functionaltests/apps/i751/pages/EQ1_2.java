package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {
	private DateTag dateOfExpiry;

	public EQ1_2(WebDriver driver) {
		super(driver);

	}

	public void set_expiryDate(Properties data) {

		dateOfExpiry = new DateTag(driver, "quiz.expireDate");
		dateOfExpiry.selectDate(data.getProperty("I751_DOE"));
		saveScreenShot("i751", this.getClass().getSimpleName()); clickContinueInEQ();
	}

}

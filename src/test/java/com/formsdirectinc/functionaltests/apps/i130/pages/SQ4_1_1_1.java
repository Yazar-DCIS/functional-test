package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1_1_1 extends WizardPage {

	public SQ4_1_1_1(WebDriver driver) {
		super(driver);

	}

	private PhoneNumber foreignPhone;

	public SQ4_1_1_1 spouseForeignPhone(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			foreignPhone = new PhoneNumber(driver,
					"applicationData-spouseInfo.foreignPhone");
			foreignPhone.setPhoneCode(data.getProperty("Phone1"));
			foreignPhone.setPhoneNumber(data.getProperty("Phone2"));
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

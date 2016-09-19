package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_7 extends WizardPage {

	private Numbers i94_number;

	public SQ2_7(WebDriver driver) {
		super(driver);

	}

	public SQ2_7 i_94Number(Properties data, String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {
			i94_number = new Numbers(driver, "applicantInfo.i94Number");
			i94_number.setArrivalRecordNumber(
					data.getProperty("arrival_number1"),
					data.getProperty("arrival_number2"));

			saveScreenShot("I102", "SQ2_7"); clickContinueInSQ();
		}
		return this;
	}

}

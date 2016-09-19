package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_7_1 extends WizardPage {

	private Numbers i95_number;

	public SQ2_7_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_7_1 i_95Number(Properties data, String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {

			i95_number = new Numbers(driver, "applicantInfo.i95Number");
			i95_number.setArrivalRecordNumber(
					data.getProperty("arrival_number1"),
					data.getProperty("arrival_number2"));
			saveScreenShot("I102", "SQ2_7"); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_6 extends WizardPage {

	private YesNo arn;
	private Numbers arn_No;

	public SQ2_6(WebDriver driver) {
		super(driver);
	}

	public SQ2_6 fianceARNDetails(Properties data, String fianceHaveARN)
			throws Exception {
		
		arn = new YesNo(driver, "foreignFiance.haveARNNumber");
		if (fianceHaveARN.equalsIgnoreCase("Yes")) {
			arn.yes();

			arn_No = new Numbers(driver, "applicationData-foreignFiance.ARN");
			arn_No.setAlienRegistrationNumber(data.getProperty("ARN"));
		}
		else if (fianceHaveARN.equalsIgnoreCase("No")) {
			arn.no();
		}
		saveScreenShot("i129f", "SQ2_6"); clickContinueInSQ();
		return this;
	}
}
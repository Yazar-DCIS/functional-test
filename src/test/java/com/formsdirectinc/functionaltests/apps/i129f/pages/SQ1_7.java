package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_7 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_7 extends WizardPage {

	private YesNo arn;
	private Numbers arn_No;

	public SQ1_7(WebDriver driver) {
		super(driver);
	}

	public SQ1_7 arnDetails(Properties data, String havArnDetails)
			throws Exception {
		
		arn = new YesNo(driver, "applicant.haveARN");
		if (havArnDetails.equalsIgnoreCase("Yes")) {
			arn.yes();

			arn_No = new Numbers(driver, "applicationData-applicant.ARN");
			arn_No.setAlienRegistrationNumber(data.getProperty("ARN"));
		}
		else if (havArnDetails.equalsIgnoreCase("No")) {
			arn.no();
		}
		saveScreenShot("i129f", "SQ1_7"); clickContinueInSQ();
		return this;
	}

}
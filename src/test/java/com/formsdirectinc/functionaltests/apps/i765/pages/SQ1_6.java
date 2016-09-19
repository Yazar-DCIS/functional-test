package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6 extends WizardPage {

	private YesNo arn;
	private Numbers arn_No;

	public SQ1_6(WebDriver driver) {
		super(driver);
	}

	public SQ1_6 ARNDetails(Properties data, String havArnDetails)
			throws Exception {
		
		arn = new YesNo(driver, "formSpecific.haveARN");
		arn.setYesOrNo(havArnDetails);
		
		if (havArnDetails.equalsIgnoreCase("Yes")) {
		
			arn_No = new Numbers(driver, "applicationData-applicant.ARN");
			arn_No.setAlienRegistrationNumber(data.getProperty("ARN"));
		}
		
		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}
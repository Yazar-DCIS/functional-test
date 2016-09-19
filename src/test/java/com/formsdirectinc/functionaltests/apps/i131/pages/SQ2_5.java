package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_5 extends WizardPage {
	private CommonInputClasses arn;

	public SQ2_5(WebDriver driver) {
		super(driver);
	}

	public SQ2_5 arnNo(Properties data) {
		
		arn = new CommonInputClasses(driver);
		arn.applicantARNDetails("applicationData-applicant.ARN", data);
		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

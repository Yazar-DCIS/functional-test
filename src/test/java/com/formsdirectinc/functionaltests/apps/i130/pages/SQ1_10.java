package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_10 extends WizardPage {

	private YesNo hasARN;
	private Numbers arn_No;

	public SQ1_10(WebDriver driver) {
		super(driver);

	}

	public SQ1_10 applicantARN_Details(String answerForARN, Properties data) {

		if (!answerForARN.equalsIgnoreCase("na")) {

			hasARN = new YesNo(driver, "applicant.hasARN");

			if (answerForARN.equalsIgnoreCase("Yes")) {
				hasARN.yes();
				setARN_No(data);
			}

			else if (answerForARN.equalsIgnoreCase("No")) {
				hasARN.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public void setARN_No(Properties data) {
		arn_No = new Numbers(driver, "applicationData-applicant.ARN");
		arn_No.setAlienRegistrationNumber(data.getProperty("ARN"));
	}

}

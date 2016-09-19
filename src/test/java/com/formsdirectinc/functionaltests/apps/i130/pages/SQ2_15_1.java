package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_15_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_15_1 extends WizardPage {

	private Numbers arn;
	private YesNo haveARNDetails;

	public SQ2_15_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_15_1 relativeARN_Details(String haveARN, Properties data) {

		if (haveARN.equalsIgnoreCase("yes")||haveARN.equalsIgnoreCase("no")) {
			haveARNDetails = new YesNo(driver, "relative.hasARN");

			if (haveARN.equalsIgnoreCase("Yes")) {
				haveARNDetails.yes();
				arn = new Numbers(driver, "applicationData-relative");
				arn.setAlienRegistrationNumberInCaps(data.getProperty("ARN"));
			}

			else if (haveARN.equalsIgnoreCase("No")) {
				haveARNDetails.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

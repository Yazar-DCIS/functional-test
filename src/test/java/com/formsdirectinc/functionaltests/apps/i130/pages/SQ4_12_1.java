package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_12_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_12_1 extends WizardPage {

	private Numbers arn;
	private YesNo haveARNDetails;

	public SQ4_12_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_12_1 spouseARN_Details(String haveARN, Properties data) {

		if (haveARN.equalsIgnoreCase("yes")||haveARN.equalsIgnoreCase("no")) {
			haveARNDetails = new YesNo(driver, "spouseInfo.hasARN");
			haveARNDetails.setYesOrNo(haveARN);
			
			if (haveARN.equalsIgnoreCase("Yes")) {
				arn = new Numbers(driver, "applicationData-spouseInfo");
				arn.setAlienRegistrationNumberInCaps(data.getProperty("ARN"));
			}
	
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

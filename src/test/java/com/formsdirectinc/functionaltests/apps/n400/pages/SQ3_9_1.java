package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_9_1 extends WizardPage {

	
	public SQ3_9_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_9_1 spouseARNDetails(Properties copies, Properties data,
			String visitPage) {
		if (visitPage.equalsIgnoreCase("Yes")) {

			Numbers spouseARN=new Numbers(driver, "applicationData-currentSpouse.ARN");
			spouseARN.setAlienRegistrationNumber(data.getProperty("ARN"));
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_9_1");
			 clickContinueInSQ();
		}
		return this;
	}

}

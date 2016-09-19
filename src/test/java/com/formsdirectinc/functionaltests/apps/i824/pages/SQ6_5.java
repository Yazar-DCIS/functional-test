package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_5 extends WizardPage {

	private AdditionalInfoFields initialApplication;

	public SQ6_5(WebDriver driver) {
		super(driver);

	}

	public void applicantARNDetails(Properties data) {

		initialApplication = new AdditionalInfoFields(driver,
				"applicationData-beneficiary.arnNumber");
		initialApplication.normalText(data.getProperty("ARN"));

	}

}

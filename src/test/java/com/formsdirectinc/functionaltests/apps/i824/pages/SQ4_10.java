package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_10 extends WizardPage {

	
	

	private CommonInputClasses initialApplication;

	public SQ4_10(WebDriver driver) {
		super(driver);

	}

	public void applicantSSNDetails(Properties data) {

		initialApplication = new CommonInputClasses(driver);
		initialApplication.applicantSSNDetails("applicationData-applicant.SSN",
				data);

	}

}

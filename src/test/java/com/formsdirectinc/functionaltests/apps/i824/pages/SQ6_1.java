package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_1 extends WizardPage {

	
	

	private CommonInputClasses initialApplication;

	public SQ6_1(WebDriver driver) {
		super(driver);

	}

	public void beneficiaryNameDetails(Properties data) {

		initialApplication = new CommonInputClasses(driver);
		initialApplication.applicantNameDetails("beneficiary.name", data);

	}

}

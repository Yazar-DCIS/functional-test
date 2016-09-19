package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_2 extends WizardPage {

	
	

	private CommonInputClasses initialApplication;
	private YesNo sameAddress;

	public SQ4_2(WebDriver driver) {
		super(driver);

	}

	public void applicantAddressDetails(Properties data) {

		initialApplication = new CommonInputClasses(driver);
		initialApplication.applicantAddressDetails(
				"applicationData-applicant.homeAddress", data);

		sameAddress = new YesNo(driver, "applicant.sameAddress");
		sameAddress.yes();

		sameAddress = new YesNo(driver, "applicant.careOf.hasInCareOfAgent");
		sameAddress.no();

	}

}

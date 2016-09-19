package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {
	private Numbers arnStatus;
	private YesNo beneficiaryARN;

	public SQ2_6(WebDriver driver) {
		super(driver);

	}

	public void arnStatus(Properties data) {

		arnStatus = new Numbers(driver,
				"applicationData-principalApplicant.ARN");
		arnStatus.setAlienRegistrationNumber(data.getProperty("ARN"));

	}

	public void beneficiaryARNStatus() {

		beneficiaryARN = new YesNo(driver, "beneficiaryFormSpecific.haveARN");
		beneficiaryARN.no();

	}

}

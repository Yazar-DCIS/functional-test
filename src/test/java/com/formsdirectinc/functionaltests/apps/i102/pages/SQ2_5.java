package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_5 extends WizardPage {

	private Numbers alienNumber;
	private YesNo haveARN;

	public SQ2_5(WebDriver driver) {
		super(driver);

	}

	public SQ2_5 haveARN(Properties data, String haveARnumber) {

		haveARN = new YesNo(driver, "applicantInfo.haveARN");

		if (haveARnumber.equalsIgnoreCase("Yes")) {

			haveARN.yes();
			alienNumber = new Numbers(driver,
					"applicationData-applicantInfo.ARN");
			alienNumber.setAlienRegistrationNumber(data.getProperty("ARN"));
		}

		else if (haveARnumber.equalsIgnoreCase("No")) {
			haveARN.no();
		}

		saveScreenShot("I102", "SQ2_5"); clickContinueInSQ();
		return this;

	}

}

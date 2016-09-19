package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_6_1 extends WizardPage {

	private YesNo haveELIS;
	private AdditionalInfoFields elisNumber;

	public SQ2_6_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_6_1 haveELIS_Number(Properties data, String haveELISNumber) {
		haveELIS = new YesNo(driver, "applicantInfo.haveElis");

		if (haveELISNumber.equalsIgnoreCase("Yes")) {
			haveELIS.yes();
			elisNumber = new AdditionalInfoFields(driver,
					"applicationData-applicantInfo.haveElisNumber");
			elisNumber.normalText(data.getProperty("ELIS"));

		}
		else if (haveELISNumber.equalsIgnoreCase("No")) {
			haveELIS.no();
		}

		saveScreenShot("I102", "SQ2_6_1"); clickContinueInSQ();
		return this;

	}

}

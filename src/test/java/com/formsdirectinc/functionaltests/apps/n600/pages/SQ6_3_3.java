package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_3_3 extends WizardPage {

	protected AdditionalInfoFields naturalizationNumber, alienNumber;

	public SQ6_3_3(WebDriver driver) {
		super(driver);

	}

	public SQ6_3_3 naturalizationNumber(Properties data, String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			naturalizationNumber = new AdditionalInfoFields(driver,

			"applicationData-applicant.motherInfo.naturalization.naturalizationNumber");
			naturalizationNumber.isStatusOther(data.getProperty("ARN"));

			alienNumber = new AdditionalInfoFields(driver,
					"applicationData-applicant.motherInfo.naturalization.formerANumber");
			alienNumber.isStatusOther(data.getProperty("ARN"));

			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}

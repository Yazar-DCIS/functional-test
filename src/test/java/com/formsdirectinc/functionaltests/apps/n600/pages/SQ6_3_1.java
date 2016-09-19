package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ6_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_3_1 extends WizardPage {

	protected MultiRadioOptions citizenshipMeans;
	protected AdditionalInfoFields citizenshipNumber, alienNumber;

	public SQ6_3_1(WebDriver driver) {
		super(driver);

	}

	public SQ6_3_1 citizenshipType(Properties data, String citizenshipType) {

		if (!citizenshipType.equalsIgnoreCase("NA")) {

			citizenshipMeans = new MultiRadioOptions(driver,
					"applicationData-applicant.motherInfo.citizenshipStatus");

			if (citizenshipType.equalsIgnoreCase("Birth")) {
				citizenshipMeans.selectOption(1);
				citizenshipNumber = new AdditionalInfoFields(
						driver,

						"applicationData-applicant.motherInfo.naturalization.certificateCitizenshipNumber");
				citizenshipNumber.isStatusOther(data.getProperty("ARN"));

				alienNumber = new AdditionalInfoFields(driver,

				"applicationData-applicant.motherInfo.naturalization.alienNumber");
				alienNumber.isStatusOther(data.getProperty("ARN"));
			}
			else if (citizenshipType.equalsIgnoreCase("Acquisition")) {
				citizenshipMeans.selectOption(2);
			}
			else if (citizenshipType.equalsIgnoreCase("Naturalization")) {
				citizenshipMeans.selectOption(3);
			}
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

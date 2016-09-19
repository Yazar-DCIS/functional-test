package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1_2 extends WizardPage {

	private AdditionalInfoFields placeOfAdmission;
	private DateTag dateOfAdmission;

	public SQ3_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_2 dateAndPlaceOfAdmission(Properties data,
			String visitPage) {

		if (!(visitPage.equalsIgnoreCase("Skip"))) {

			dateOfAdmission = new DateTag(driver,
					"statusInfo.dateOfLastAdmissionToUS");
			dateOfAdmission.selectDate(data.getProperty("DOA"));

			placeOfAdmission = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.placeOfLastAdmissionToUS");
			placeOfAdmission.normalText(data.getProperty("City"));

			saveScreenShot("I102", "SQ3_1_2"); clickContinueInSQ();
		}

		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1 extends WizardPage {

	private AdditionalInfoFields placeOfAdmission;
	private DateTag dateOfAdmission;
	private MultiRadioOptions seekingStatus;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 lastDateAndPlaceOfAdmission(Properties data,
			String seekingToReplaceStatus) {

		if (!(seekingToReplaceStatus.equalsIgnoreCase("skip"))) {

			dateOfAdmission = new DateTag(driver,
					"statusInfo.dateOfLastAdmission");
			dateOfAdmission.selectDate(data.getProperty("DOA"));

			placeOfAdmission = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.placeOfLastAdmission");
			placeOfAdmission.isStatusOther(data.getProperty("City"));

			seekingStatus = new MultiRadioOptions(driver,
					"applicationData-statusInfo.seekingToReplace");

			if (seekingToReplaceStatus.equalsIgnoreCase("Yes")) {
				seekingStatus.selectOption(1);
			}

			else if (seekingToReplaceStatus.equalsIgnoreCase("No")) {
				seekingStatus.selectOption(2);
			}

			else if (seekingToReplaceStatus.equalsIgnoreCase("Unknown")) {
				seekingStatus.selectOption(3);
			}

			saveScreenShot("I102", "SQ3_1"); clickContinueInSQ();

		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {
	// SQ 3.3

	private DateTag dateEntered;
	private Name_FirstMiddleLast nameAtEntry;
	private YesNo sameNameFR;
	private AdditionalInfoFields countryEntered;

	public SQ3_3(WebDriver driver) {
		super(driver);

	}

	public SQ3_3 entryIntoUS_part1(Properties data, String sameName) {

		if (!sameName.equalsIgnoreCase("NA")) {

			sameNameFR = new YesNo(driver,
					"applicant.entryNameSameAsCurrentLegalName");
			sameNameFR.setYesOrNo(sameName);
			

			if (sameName.equalsIgnoreCase("No")) {
				
				nameAtEntry = new Name_FirstMiddleLast(driver,
						"applicationData",

						"applicant.additionalInfo.entryIntoUS.nameAtTimeOfEntry");
				nameAtEntry.setFirstNameField(data.getProperty("FirstName"));
				nameAtEntry.setMiddleNameField(data.getProperty("MiddleName"));
				nameAtEntry.setLastNameField(data.getProperty("LastName"));
			}

			countryEntered = new AdditionalInfoFields(driver,

			"applicationData-applicant.additionalInfo.entryIntoUS.cityEntered.name");
			countryEntered.selectDDM("ABERDEEN, WA (ABE)");

			dateEntered = new DateTag(driver,
					"applicant.additionalInfo.entryIntoUS.dateEntered");
			dateEntered.selectDateAsSingle(data.getProperty("DateEntered"));

			saveScreenShot("n600", "SQ3_3"); clickContinueInSQ();
		}
		return this;
	}

}

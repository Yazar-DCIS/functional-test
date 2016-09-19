package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_6_2 extends WizardPage {

	private MultiRadioOptions entryDocument;
	private Country passportIssuedCountry, travelDocumentIssuedCountry;
	private DateTag passportExpiyDate, travelDocumentExpiyDate;
	private AdditionalInfoFields passportNumber, travelDocumentNumber;

	public SQ2_6_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_6_2 travelDocument(Properties data, String entryToUS) {

		entryDocument = new MultiRadioOptions(driver,
				"applicationData-applicantInfo.passportAndTravel.entryDocument.usEntryDocument");

		if (entryToUS.equalsIgnoreCase("Passport")) {

			entryDocument.selectOption(1);

			passportNumber = new AdditionalInfoFields(driver,

			"applicationData-applicantInfo.passportAndTravel.entryDocument");
			passportNumber.passportNumber(data.getProperty("PassportNumber"));

			passportIssuedCountry = new Country(driver,
					"applicationData-applicantInfo.passportAndTravel.entryDocument");
			passportIssuedCountry.setPassportCountry(data
					.getProperty("DOB_Country"));

			passportExpiyDate = new DateTag(driver,
					"applicantInfo.passportAndTravel.entryDocument.passportDate");
			passportExpiyDate.selectDate(data.getProperty("DOE"));

		}
		else if (entryToUS.equalsIgnoreCase("Travel_Document ")) {
			entryDocument.selectOption(2);

			travelDocumentNumber = new AdditionalInfoFields(driver,

			"applicationData-applicantInfo.passportAndTravel.entryDocument.travelNumber");
			travelDocumentNumber.normalText(data.getProperty("PassportNumber"));

			travelDocumentIssuedCountry = new Country(driver,

			"applicationData-applicantInfo.passportAndTravel.entryDocument");
			travelDocumentIssuedCountry.setTravelCountry(data
					.getProperty("DOB_Country"));

			travelDocumentExpiyDate = new DateTag(driver,
					"applicantInfo.passportAndTravel.entryDocument.travelDate");
			travelDocumentExpiyDate.selectDate(data.getProperty("DOE"));

		}
		saveScreenShot("I102", "SQ2_6_2"); clickContinueInSQ();

		return this;
	}

}

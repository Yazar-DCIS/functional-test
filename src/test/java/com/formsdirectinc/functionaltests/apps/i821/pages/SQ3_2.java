package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	
	private YesNo validImmigrationStatus;
	private AdditionalInfoFields nonImmigrantClass;
	private YesNo travelDocument;
	private AdditionalInfoFields outOfStatus;
	private Numbers i94Number;
	private MultiRadioOptions documentType;
	private AdditionalInfoFields passportNumber;
	private AdditionalInfoFields travelDocNumber;
	private Address countryOfIssuanceTravel;
	private DateTag travelDateExpire;
	private DateTag dateAuthourized;

	public SQ3_2 classofAdmission(String classofadmission,
			String traveldocument, String passportandtravel, Properties data) {
		if (!classofadmission.equalsIgnoreCase("NA")) {
			validImmigrationStatus = new YesNo(driver,
					"formSpecific.validImmigrationStatus");

			if (classofadmission.equalsIgnoreCase("Yes")) {
				validImmigrationStatus.yes();

				nonImmigrantClass = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.nonImmigrantClassification");
				nonImmigrantClass.selectDDM(data.getProperty("POE_Manner"));

			}
			else if (classofadmission.equalsIgnoreCase("No")) {
				validImmigrationStatus.no();

				outOfStatus = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.outOfStatus");
				outOfStatus.normalText(data.getProperty("i821_outofstatus"));
			}
			travelDocument = new YesNo(driver, "formSpecific.havingI94Num");
			if (traveldocument.equalsIgnoreCase("Yes")) {
				travelDocument.yes();

				i94Number = new Numbers(driver, "formSpecific.i94Number");
				i94Number.setArrivalRecordNumber(data.getProperty("i94_1"),
						data.getProperty("i94_2"));

				dateAuthourized = new DateTag(driver,
						"formSpecific.dateAuthourized");
				dateAuthourized.selectDateAsSingle(data
						.getProperty("I765_EADCardExpirationDate"));
			}
			else if (traveldocument.equalsIgnoreCase("No")) {
				travelDocument.no();
			}

			documentType = new MultiRadioOptions(driver,
					"applicationData-formSpecific.passportAndTravel.documentUsedOnEntry");
			if (passportandtravel.equalsIgnoreCase("Passport")) {

				documentType.selectOption(1);

				passportNumber = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.passportAndTravel.passportNumber");
				passportNumber.normalText(data.getProperty("PassportNumber"));

				countryOfIssuanceTravel = new Address(driver,

				"applicationData-formSpecific.passportAndTravel.countryOfIssuance");
				countryOfIssuanceTravel.setCountryDropDown(data
						.getProperty("Country"));

				travelDateExpire = new DateTag(driver,
						"formSpecific.passportAndTravel.passportDateExpire");
				travelDateExpire.selectDateAsSingle(data
						.getProperty("expDate_i94"));

			}
			else if (passportandtravel.equalsIgnoreCase("Travel Document")) {
				documentType.selectOption(2);

				travelDocNumber = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.passportAndTravel.travelDocNumber");
				travelDocNumber.normalText(data.getProperty("PassportNumber"));

				countryOfIssuanceTravel = new Address(driver,

				"applicationData-formSpecific.passportAndTravel.countryOfIssuanceTravel");
				countryOfIssuanceTravel.setCountryDropDown(data
						.getProperty("Country"));

				travelDateExpire = new DateTag(driver,
						"formSpecific.passportAndTravel.travelDateExpire");
				travelDateExpire.selectDateAsSingle(data
						.getProperty("expDate_i94"));

			}
			else if (passportandtravel.equalsIgnoreCase("none")) {
				documentType.selectOption(3);
			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_10 extends WizardPage {
	private YesNo everBeenInUS, currentlyInUS;
	private AdditionalInfoFields statusEnteredCountry, documentNumber;
	private SelectElement i94adn1, i94adn2;
	private DateTag dateEnteredUS, expiryDate, documentExpirationDate;
	
	private Address documentCountry;
	private MultiRadioOptions entryDocument;

	public SQ2_10(WebDriver driver) {
		super(driver);
	}

	public SQ2_10 fianceUsTravel(Properties data, String fianceEverBeenInUS,
			String i94StatusValid, String documentUsedForEntry) {
		everBeenInUS = new YesNo(driver, "foreignFiance.beenInUS");
		if (fianceEverBeenInUS.equalsIgnoreCase("Yes")) {
			everBeenInUS.yes();

			currentlyInUS = new YesNo(driver, "foreignFiance.currentlyInUS");
			currentlyInUS.yes();

			statusEnteredCountry = new AdditionalInfoFields(driver,

			"applicationData-foreignFiance.statusOfEntry");
			statusEnteredCountry.normalText(data.getProperty("status_student"));

			i94adn1 = new SelectElement(driver,
					"foreignFiance.arrivalDepartureNumber.adn1");
			i94adn2 = new SelectElement(driver,
					"foreignFiance.arrivalDepartureNumber.adn2");
			i94adn1.sendValuesUsingElementName(data.getProperty("i94_1"));
			i94adn2.sendValuesUsingElementName(data.getProperty("i94_2"));

			dateEnteredUS = new DateTag(driver,
					"foreignFiance.dateArraivedInUS");
			dateEnteredUS.selectDateAsSingle(data.getProperty("DateEntered"));

			expiryDate = new DateTag(driver,
					"foreignFiance.statusExpiryDate");
			expiryDate.selectDateAsSingle(data
					.getProperty("passportExpiry"));

			entryDocument = new MultiRadioOptions(driver,
					"applicationData-foreignFiance.documentSelection");

			if (documentUsedForEntry.equalsIgnoreCase("Passport")) {

				entryDocument.selectOption(1);

				documentNumber = new AdditionalInfoFields(driver,

				"applicationData-foreignFiance.passportNumber");
				documentNumber.normalText(data.getProperty("PassportNumber"));

				documentCountry = new Address(driver,
						"applicationData-foreignFiance.passportIssuance");
				documentCountry.setCountryDropDown(data
						.getProperty("I134_Country"));

				documentExpirationDate = new DateTag(driver,
						"foreignFiance.passportExpiryDate");
				documentExpirationDate.selectDateAsSingle(data
						.getProperty("passportExpiry"));

			}
			else if (documentUsedForEntry.equalsIgnoreCase("TravelDocument")) {

				entryDocument.selectOption(2);

				documentNumber = new AdditionalInfoFields(driver,

				"applicationData-foreignFiance.travelDocumentNumber");
				documentNumber.normalText(data.getProperty("PassportNumber"));

				documentCountry = new Address(driver,
						"applicationData-foreignFiance.travelDocumentIssuance");
				documentCountry.setCountryDropDown(data
						.getProperty("I134_Country"));

				documentExpirationDate = new DateTag(driver,
						"foreignFiance.travelDocumentExpiryDate");
				documentExpirationDate.selectDateAsSingle(data
						.getProperty("passportExpiry"));
			}
		}
		else if (fianceEverBeenInUS.equalsIgnoreCase("No")) {
			everBeenInUS.no();
		}
		saveScreenShot("i129f", "SQ2_10"); clickContinueInSQ();
		return this;
	}
}

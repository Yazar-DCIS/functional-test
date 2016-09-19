package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_9 extends WizardPage {

	private MultiRadioOptions usEntryDocument;
	private AdditionalInfoFields passport;
	private Address passport_Office;
	private DateTag passportpassportExpireOn;

	public SQ2_9(WebDriver driver) {
		super(driver);
	}

	public void set_usEntryDocument() {
		usEntryDocument = new MultiRadioOptions(driver,
				"applicationData-applicant.usEntryDocument");
		usEntryDocument.selectOption(1);
	}

	public void set_Passport(Properties data) {
		passport = new AdditionalInfoFields(driver, "applicationData-applicant");
		passport.passportNumber(data.getProperty("PassportNumber"));

	}

	public void set_PassportIssued(Properties data) {
		passport_Office = new Address(driver,
				"applicationData-applicant.passportIssuedCountry");
		passport_Office.setCountry(data.getProperty("Country"));
		passportpassportExpireOn = new DateTag(driver,
				"applicant.passportExpireOn");
		passportpassportExpireOn.selectDateAsSingle(data.getProperty("DOExp"));
	}

}

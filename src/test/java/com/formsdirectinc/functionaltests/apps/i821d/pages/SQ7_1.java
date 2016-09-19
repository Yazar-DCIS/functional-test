package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_1 extends WizardPage {
	private MultiRadioOptions certification;
	private Name_FirstMiddleLast applicantName;
	private AdditionalInfoFields language;
	private AdditionalInfoFields organisation;
	private Address applicantAddresses;

	public SQ7_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_1 certification(String interpreter, Properties data)
			throws Exception {

		if (!interpreter.equalsIgnoreCase("Skip")) {
			if (interpreter.equalsIgnoreCase("Yes")) {
				certification = new MultiRadioOptions(driver,

				"applicationData-interpreterInformation.readAndUnderstandEnglish");
				certification.selectOption(2);

				language = new AdditionalInfoFields(driver,
						"applicationData-interpreterInformation.languageOfinterpreter");
				language.normalText(data.getProperty("interpreterLanguage"));

				applicantName = new Name_FirstMiddleLast(driver,
						"applicationData",

						"interpreterInformation.nameOfinterpreter");
				applicantName.setFirstNameField(data.getProperty("FirstName"));
				applicantName.setLastNameField(data.getProperty("LastName"));

				organisation = new AdditionalInfoFields(driver,

				"applicationData-interpreterInformation.businessName");
				organisation.normalText(data.getProperty("organisation"));

				applicantAddresses = new Address(driver,
						"applicationData-interpreterInformation.mailingAddress.country");
				applicantAddresses.setCountryDropDown(data
						.getProperty("DOB_Country"));

				applicantAddresses = new Address(driver,
						"applicationData-interpreterInformation.mailingAddress");
				applicantAddresses.setStreet(data.getProperty("StreetName"));
				applicantAddresses.setCity(data.getProperty("City"));
				applicantAddresses.setStateText(data.getProperty("State"));
				applicantAddresses.setZipcode(data.getProperty("Zipcode"));
			}

			else if (interpreter.equalsIgnoreCase("No")) {

				certification = new MultiRadioOptions(driver,

				"applicationData-interpreterInformation.readAndUnderstandEnglish");
				certification.selectOption(1);

			}

		}
		return this;
	}
}

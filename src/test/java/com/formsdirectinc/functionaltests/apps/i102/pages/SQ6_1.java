package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_1 extends WizardPage {

	private MultiRadioOptions certification;
	private Name_FirstMiddleLast applicantName;
	private AdditionalInfoFields language;
	private AdditionalInfoFields organisation;
	private Address applicantAddresses;

	public SQ6_1(WebDriver driver) {
		super(driver);
	}

	public SQ6_1 applicantStatement(Properties data, String interpreter) {
		if (!interpreter.equalsIgnoreCase("Skip")) {

			certification = new MultiRadioOptions(driver,
					"applicationData-formSpecific.statement.languageSkill");

			if (interpreter.equalsIgnoreCase("Yes")) {

				certification.selectOption(2);

				language = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.statement.interpretedLanguage");
				language.normalText(data.getProperty("interpreterLanguage"));

				applicantName = new Name_FirstMiddleLast(driver,
						"applicationData",

						"formSpecific.statement.interpreterName");
				applicantName.setFirstNameField(data.getProperty("FirstName"));
				applicantName.setLastNameField(data.getProperty("LastName"));

				organisation = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.statement.businessName");
				organisation.normalText(data.getProperty("organisation"));

				applicantAddresses = new Address(driver,
						"applicationData-formSpecific.statement.interpreterAddress.country");
				applicantAddresses.setCountryDropDown(data
						.getProperty("DOB_Country"));

				applicantAddresses = new Address(driver,
						"applicationData-formSpecific.statement.interpreterAddress");
				applicantAddresses.setStreet(data.getProperty("StreetName"));
				applicantAddresses.setCity(data.getProperty("City"));
				applicantAddresses.setStateText(data.getProperty("State"));
				applicantAddresses.setZipcode(data.getProperty("Zipcode"));
			}

			else if (interpreter.equalsIgnoreCase("No")) {

				certification.selectOption(1);

			}

			saveScreenShot("I102", "SQ6_1"); clickContinueInSQ();
		}
		return this;
	}

}

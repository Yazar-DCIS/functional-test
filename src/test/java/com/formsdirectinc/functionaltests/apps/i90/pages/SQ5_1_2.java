package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90:Preparer Info
 * 
 * @author Orina
 */

public class SQ5_1_2 extends WizardPage {

	private MultiRadioOptions someOneAssistYou;

	public SQ5_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_2 preparerInfo(Properties data, String someOneAssisting,
			String isPreparerAnAttorney, String didAttorneyExtendBeyond,
			String workingWithOrgForInterpretation) {

		someOneAssistYou = new MultiRadioOptions(driver,
				"applicationData-applicant.preparerInfo.someOneAssistYou");

		if (someOneAssisting.equalsIgnoreCase("no")) {
			someOneAssistYou.selectOption(1);
		}

		else if (someOneAssisting.equalsIgnoreCase("yes")) {
			someOneAssistYou.selectOption(2);

			MultiRadioOptions haveAttorney = new MultiRadioOptions(driver,
					"applicationData-applicant.preparerInfo.isPreparerAnAttorney");

			if (isPreparerAnAttorney.equalsIgnoreCase("yes")) {
				haveAttorney.selectOption(1);

				MultiRadioOptions extendedBeyond = new MultiRadioOptions(
						driver,
						"applicationData-applicant.preparerInfo.didAttorneyExtendBeyond");
				if (didAttorneyExtendBeyond.equalsIgnoreCase("yes")) {
					extendedBeyond.selectOption(1);
				} else if (didAttorneyExtendBeyond.equalsIgnoreCase("no")) {
					extendedBeyond.selectOption(2);
				}

				SelectElement nameOfOrganisation = new SelectElement(driver,
						"applicationData-applicant.preparerInfo.lawFirmName");
				nameOfOrganisation.sendValuesUsingElementID(data
						.getProperty("applicant.preparerInfo.lawFirmName"));

				Name_FirstMiddleLast interpreterName = new Name_FirstMiddleLast(
						driver, "applicationData",
						"applicant.preparerInfo.nameOfPreparer");
				interpreterName
				.setFirstNameField(data
						.getProperty("applicant.preparerInfo.nameOfPreparer.first"));
				interpreterName
				.setLastNameField(data
						.getProperty("applicant.preparerInfo.nameOfPreparer.last"));

				Address interpreterAddress = new Address(driver,
						"applicationData-applicant.preparerInfo.addressOfPreparer");
				interpreterAddress
				.setStreet(data
						.getProperty("applicant.preparerInfo.addressOfPreparer.street"));
				interpreterAddress
				.setCity(data
						.getProperty("applicant.preparerInfo.addressOfPreparer.city"));
				interpreterAddress
				.setState(data
						.getProperty("applicant.preparerInfo.addressOfPreparer.state"));
				interpreterAddress
				.setZipcode(data
						.getProperty("applicant.preparerInfo.addressOfPreparer.zipcode"));

				PhoneNumber interpreterNumber = new PhoneNumber(driver,
						"applicationData-applicant.preparerInfo.daytimePhoneOfPreparer");
				interpreterNumber
				.setPhoneCode(data
						.getProperty("applicant.preparerInfo.daytimePhoneOfPreparer.phone1"));
				interpreterNumber
				.setPhoneNumber(data
						.getProperty("applicant.preparerInfo.daytimePhoneOfPreparer.phone2"));

			} else if (isPreparerAnAttorney.equalsIgnoreCase("no")) {
				haveAttorney.selectOption(2);

				MultiRadioOptions helpViaOrganisations = new MultiRadioOptions(
						driver,
						"applicationData-applicant.certification.workingWithOrgForInterpretation");
				if (workingWithOrgForInterpretation.equalsIgnoreCase("yes")) {

					helpViaOrganisations.selectOption(1);

					SelectElement nameOfOrganisation = new SelectElement(
							driver,
							"applicationData-applicant.certification.businessNameOfinterpreter");
					nameOfOrganisation
					.sendValuesUsingElementID(data
							.getProperty("applicant.certification.businessNameOfinterpreter"));
				} else if (workingWithOrgForInterpretation
						.equalsIgnoreCase("no")) {
					helpViaOrganisations.selectOption(2);
				}

				Name_FirstMiddleLast interpreterName = new Name_FirstMiddleLast(
						driver, "applicationData",
						"applicant.certification.nameOfinterpreter");
				interpreterName
				.setFirstNameField(data
						.getProperty("applicant.certification.nameOfInterpreter.first"));
				interpreterName
				.setLastNameField(data
						.getProperty("applicant.certification.nameOfInterpreter.last"));

				Address interpreterAddress = new Address(driver,
						"applicationData-applicant.certification.mailingAddressOfInterpreter");
				interpreterAddress
				.setStreet(data
						.getProperty("applicant.certification.mailingAddressOfInterpreter.street"));
				interpreterAddress
				.setCity(data
						.getProperty("applicant.certification.mailingAddressOfInterpreter.city"));
				interpreterAddress
				.setState(data
						.getProperty("applicant.certification.mailingAddressOfInterpreter.state"));
				interpreterAddress
				.setZipcode(data
						.getProperty("applicant.certification.mailingAddressOfInterpreter.zipcode"));

				PhoneNumber interpreterNumber = new PhoneNumber(driver,
						"applicationData-applicant.certification.phoneOfInterpreter");
				interpreterNumber
				.setPhoneCode(data
						.getProperty("applicant.certification.phoneOfInterpreter.phone1"));
				interpreterNumber
				.setPhoneNumber(data
						.getProperty("applicant.certification.phoneOfInterpreter.phone2"));
			}

		}

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

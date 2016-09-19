package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_1 extends WizardPage {

	public SQ7_1(WebDriver driver) {
		super(driver);
	}

	
	private MultiRadioOptions readAndUnderstandEnglish;
	private AdditionalInfoFields languageOfinterpreter;
	private Name_FirstMiddleLast nameOfinterpreter;
	private AdditionalInfoFields businessName;
	private Address mailingAddress;
	private CommonInputClasses address;

	public SQ7_1 setCertification1(String certification, Properties data) {
		if (!certification.equalsIgnoreCase("NA")) {
			readAndUnderstandEnglish = new MultiRadioOptions(driver,

			"applicationData-applicant.certification.readAndUnderstandEnglish");
			if (certification.equalsIgnoreCase("languageOfEnglish")) {
				readAndUnderstandEnglish.selectOption(1);

			}
			else if (certification.equalsIgnoreCase("languageOfinterpreter")) {
				readAndUnderstandEnglish.selectOption(2);
				languageOfinterpreter = new AdditionalInfoFields(driver,

				"applicationData-applicant.certification.languageOfinterpreter");
				languageOfinterpreter.normalText(data
						.getProperty("interpreterLanguage"));

				nameOfinterpreter = new Name_FirstMiddleLast(driver,
						"applicationData",

						"applicant.certification.nameOfinterpreter");
				nameOfinterpreter.setFirstNameField(data
						.getProperty("FirstName1"));
				nameOfinterpreter.setLastNameField(data
						.getProperty("LastName1"));

				businessName = new AdditionalInfoFields(driver,

				"applicationData-applicant.certification.businessName");
				businessName.normalText(data.getProperty("I134_BusinessName"));

				mailingAddress = new Address(driver,
						"applicationData-applicant.certification.mailingAddress.country");
				mailingAddress.setCountryDropDown(data
						.getProperty("DOB_Country"));
				address = new CommonInputClasses(driver);
				address.applicantOtherAddressDetails(
						"applicationData-applicant.certification.mailingAddress",
						data);
				PhoneNumber contactNumber = new PhoneNumber(driver,
						"applicationData-applicant.certification.dayTimePhone");
				contactNumber.setPhoneCode(data.getProperty("Phone1"));
				contactNumber.setPhoneNumber(data.getProperty("Phone2"));

				businessName = new AdditionalInfoFields(driver,

				"applicationData-applicant.certification.emailAddress");
				businessName.normalText(data.getProperty("Mail"));

			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}
}

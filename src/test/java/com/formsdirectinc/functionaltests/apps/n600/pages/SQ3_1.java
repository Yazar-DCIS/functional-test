package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	private Address homeAddress, mailAddress;
	private YesNo sameAddress, sendToAnother, notify;
	private AdditionalInfoFields inCareName;

	public SQ3_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_1 applicantAddress(Properties data, String mailAddressSame,
			String inCareNameAvl) {

		if (!mailAddressSame.equalsIgnoreCase("NA")
				&& !inCareNameAvl.equalsIgnoreCase("NA")) {
			setHomeAdress(data);

			sameAddress = new YesNo(driver, "applicant.sameAsMailingAddress");
			sameAddress.setYesOrNo(mailAddressSame);
			if (mailAddressSame.equalsIgnoreCase("No")) {
				setMailingAdress(data);
			}

			sendToAnother = new YesNo(driver,
					"applicant.additionalInfo.mailingAddress.hasInCareOfAgent");
			sendToAnother.setYesOrNo(inCareNameAvl);
			if (inCareNameAvl.equalsIgnoreCase("Yes")) {
			
				inCareName = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.mailingAddress.inCareOfAgentName");
				inCareName.normalText(data.getProperty("Mail_CareOf"));

			}
			
			PhoneNumber contactNumber = new PhoneNumber(driver,
					"applicationData-applicant.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));
			contactNumber.setEveningTimeNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));

			contactNumber = new PhoneNumber(driver,
					"applicationData-applicant.additionalInfo");

			contactNumber.setPhone1145Number(data.getProperty("Phone1"),
					data.getProperty("Phone2"));
			contactNumber.setOldWorkPhoneNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));

			setUSCISNotifications();
			saveScreenShot("n600", "SQ3_1"); clickContinueInSQ();

		}
		return this;
	}

	public SQ3_1 setHomeAdress(Properties data) {
		homeAddress = new Address(driver,
				"applicationData-applicant.additionalInfo.homeAddress");
		homeAddress.setStreet(data.getProperty("StreetName"));
		// applicationData-applicant.additionalInfo.homeAddress-secondaryUnitType
		// homeAddress.setAptNum(data.getProperty("Apt"));
		homeAddress.setCity(data.getProperty("City"));
		homeAddress.setState(data.getProperty("State"));
		homeAddress.setZipcode(data.getProperty("Zipcode"));
		return this;
	}

	public SQ3_1 setMailingAdress(Properties data) {
		mailAddress = new Address(driver,
				"applicationData-applicant.additionalInfo.mailingAddress");
		mailAddress.setStreet(data.getProperty("StreetName"));
		// mailAddress.setAptNum(data.getProperty("Apt"));
		mailAddress.setCity(data.getProperty("City"));
		mailAddress.setState(data.getProperty("State"));
		mailAddress.setZipcode(data.getProperty("Zipcode"));
		return this;
	}

	public SQ3_1 setEmail(Properties data) {

		EMailAddress email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		email.setEMail(data.getProperty("Mail"));
		return this;
	}

	public SQ3_1 setUSCISNotifications() {

		notify = new YesNo(driver,
				"applicant.additionalInfo.sendEmailNotifications");
		notify.yes();
		return this;

	}

}

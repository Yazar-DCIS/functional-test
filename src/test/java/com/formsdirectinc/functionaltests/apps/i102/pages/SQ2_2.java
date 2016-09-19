package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2 extends WizardPage {

	private Address mailingAddress, physicalAddress;
	private YesNo hasInCareOfAgent, samePhysicalAddress;
	private AdditionalInfoFields careOf;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2 setAddressFields(Properties data, String inCareOF,
			String sameMailingAddress) {
		mailingAddress = new Address(driver,
				"applicationData-applicantInfo.mailingAddress");

		physicalAddress = new Address(driver,
				"applicationData-applicantInfo.physicalAddress");

		hasInCareOfAgent = new YesNo(driver,
				"applicantInfo.mailingAddress.hasInCareOfAgent");

		samePhysicalAddress = new YesNo(driver,
				"applicantInfo.sameMailingAddress");

		mailingAddress.setStreet(data.getProperty("StreetName"));
		mailingAddress.setCity(data.getProperty("City"));
		mailingAddress.setState(data.getProperty("State"));
		mailingAddress.setZipcode(data.getProperty("Zipcode"));

		if (inCareOF.equalsIgnoreCase("Yes")) {
			hasInCareOfAgent.yes();
			careOf = new AdditionalInfoFields(driver,
					"applicationData-applicantInfo.mailingAddress.inCareOfAgentName");
			careOf.normalText(data.getProperty("Mail_CareOf"));

		}

		else if (inCareOF.equalsIgnoreCase("No")) {
			hasInCareOfAgent.no();
		}

		if (sameMailingAddress.equalsIgnoreCase("Yes")) {
			samePhysicalAddress.yes();
		}

		else if (sameMailingAddress.equalsIgnoreCase("No")) {
			samePhysicalAddress.no();

			physicalAddress.setStreet(data.getProperty("StreetName"));
			physicalAddress.setCity(data.getProperty("City"));
			physicalAddress.setState(data.getProperty("State"));
			physicalAddress.setZipcode(data.getProperty("Zipcode"));
		}

		saveScreenShot("I102", "SQ2_2"); clickContinueInSQ();
		return this;

	}

}

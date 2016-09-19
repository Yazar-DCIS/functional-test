package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_2 extends WizardPage {

	private Address addressFields;
	private YesNo mail;
	private AdditionalInfoFields careOf;

	public SQ1_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_2 setAddressFields(String incareof, Properties data) {

		if (!incareof.equalsIgnoreCase("NA")) {
			addressFields = new Address(driver,
					"applicationData-applicant.homeAddressInCareOf");
			addressFields.setStreet(data.getProperty("StreetName"));
			addressFields.setCity(data.getProperty("City"));
			addressFields.setState(data.getProperty("State"));
			addressFields.setZipcode(data.getProperty("Zipcode"));
			// mail care of someone
			mail = new YesNo(driver,
					"applicant.homeAddressInCareOf.hasInCareOfAgent");
			mail.setYesOrNo(incareof);
			if (incareof.equalsIgnoreCase("Yes")) {
			
				careOf = new AdditionalInfoFields(driver,
						"applicationData-applicant.homeAddressInCareOf.inCareOfAgentName");
				careOf.normalText(data.getProperty("Mail_CareOf"));
			}
			
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();

		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90: Address Information
 * @author Orina
 * Revision: $Rev$
 */

public class SQ1_1_2 extends WizardPage {

	private Address addressFields;
	private YesNo mailAddress;
	private AdditionalInfoFields careOfNameText;
	private MultiRadioOptions careOfNameFR;

	public SQ1_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_2 setAddressFields(Properties data, String mailing,
			String careOf,String addressType) {

		addressFields = new Address(driver,
				"applicationData-formSpecific.residenceAddress");
		
		PropertyResource values=new PropertyResource();
		Properties properties=values.loadProperty("i90");
		addressFields.setStreetName(properties.getProperty("formSpecific.residenceAddress.streetName."+addressType));
		addressFields.setCity(properties.getProperty("formSpecific.residenceAddress.city."+addressType));
		addressFields.setState(properties.getProperty("formSpecific.residenceAddress.state."+addressType));
		addressFields.setZipcode(properties.getProperty("formSpecific.residenceAddress.zipcode."+addressType));

		mailAddress = new YesNo(driver, "formSpecific.sameAsMailingAddress");

		if (mailing.equalsIgnoreCase("yes")) {
			mailAddress.yes();
		}

		if (mailing.equalsIgnoreCase("no")) {
			
			mailAddress.no();
			
			addressFields = new Address(driver,
					"applicationData-applicant.homeAddressInCareOf");

			addressFields.setStreetName(properties.getProperty("formSpecific.residenceAddress.streetName."+addressType));
			addressFields.setCity(properties.getProperty("formSpecific.residenceAddress.city."+addressType));
			addressFields.setState(properties.getProperty("formSpecific.residenceAddress.state."+addressType));
			addressFields.setZipcode(properties.getProperty("formSpecific.residenceAddress.zipcode."+addressType));
		}

		
		careOfNameFR = new MultiRadioOptions(driver,
				"applicationData-formSpecific.residenceAddress.hasInCareOfAgent");
		if (careOf.equalsIgnoreCase("no")) {
			careOfNameFR.selectOption(1);

		}
		if (careOf.equalsIgnoreCase("yes")) {
			careOfNameFR.selectOption(2);
			
			careOfNameText = new AdditionalInfoFields(driver,
			"applicationData-formSpecific.residenceAddress.inCareOfAgentName");
			careOfNameText.isStatusOther(properties.getProperty("formSpecific.residenceAddress.inCareOfAgentName"));
		}

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}

}

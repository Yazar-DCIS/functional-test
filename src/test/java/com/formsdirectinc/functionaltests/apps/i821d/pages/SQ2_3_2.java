package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3_2 extends WizardPage {

	private Address applicantAddress;

	private DateTag dateMoved;
	private YesNo otherAddress;
	private AddAnotherField addotherAddress;

	public SQ2_3_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_3_2 applicantCurrentAddress(String otherAddresses, int count,Properties data)
			throws Exception {
		if (!otherAddresses.equalsIgnoreCase("Skip")) {
			applicantAddress = new Address(driver,
					"applicationData-applicant.currentAddress");
			applicantAddress.setStreet(data.getProperty("StreetName"));
			applicantAddress.setCity(data.getProperty("City"));
			applicantAddress.setState(data.getProperty("State"));
			applicantAddress.setZipcode(data.getProperty("Zipcode"));

			dateMoved = new DateTag(driver,
					"renewalApplication.currentAddressDate");
			dateMoved.selectDateAsSingle(data.getProperty("DateEntered"));
			otherAddress = new YesNo(driver,
					"renewalApplication.otherAddressResidence");
			otherAddress.setYesOrNo(otherAddresses);
			if (otherAddresses.equalsIgnoreCase("Yes")) {
				addotherAddress = new AddAnotherField(driver);
				addotherAddress.addAnotherAddress(count, data, "renewalApplication");
			} 

		}
		return this;

	}

}

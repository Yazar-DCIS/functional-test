package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_2 extends WizardPage {

	private Address applicantAddress;
	private DateTag dateMoved;
	private YesNo beneficiaryAddress, hasInCareOfAgent;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}
	
	public void applicantAddressDetails(Properties data) {

		
		applicantAddress = new Address(driver,
				"applicationData-principalApplicant.USAddress");
		applicantAddress.setStreet(data.getProperty("StreetName"));
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setState(data.getProperty("State"));
		applicantAddress.setZipcode(data.getProperty("Zipcode"));

		dateMoved = new DateTag(driver, "principalApplicant.movedDate");
		dateMoved.selectDate(data.getProperty("DOB"));

		
	}

	public void beneficiaryAddressDetails() {

		beneficiaryAddress = new YesNo(driver,
				"beneficiaryApplicant.sameAsCurrentAddress");
		beneficiaryAddress.yes();

		hasInCareOfAgent = new YesNo(driver,
					"beneficiaryApplicant.mailingAddress.hasInCareOfAgent");
		hasInCareOfAgent.no();
		
		
	}

}

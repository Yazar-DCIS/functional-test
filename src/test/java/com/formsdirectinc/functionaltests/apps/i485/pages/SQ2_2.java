package com.formsdirectinc.functionaltests.apps.i485.pages;

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

	private Address addressFields;
	private DateTag movedtoCountry;
	private YesNo mailAddressCare, sameAddress;

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public void setAddress(Properties data) {

		addressFields = new Address(driver,
				"applicationData-applicant.usAddress");
		addressFields.setStreet(data.getProperty("StreetName"));
		addressFields.setCity(data.getProperty("City"));
		addressFields.setState(data.getProperty("State"));
		addressFields.setZipcode(data.getProperty("Zipcode"));

	}

	public void setDateOfMoved(Properties data) {
		movedtoCountry = new DateTag(driver, "applicant.dateOfMove");
		movedtoCountry.selectDate(data.getProperty("DOB"));
	}

	public void addressCare() {
		mailAddressCare = new YesNo(driver, "applicant.hasMailingAddressCareOf");
		mailAddressCare.no();
	}

	// new control
	public void sameAddress(Properties data) {
		sameAddress = new YesNo(driver,
				"applicant.samePhysicalAndMailingAddress");
		sameAddress.yes();

		setDateOfMoved(data);

	}

}
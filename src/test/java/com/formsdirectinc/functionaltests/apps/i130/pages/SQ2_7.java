package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {

	private DateTag relativeDOB;
	private Address relativeAddress;

	public SQ2_7(WebDriver driver) {
		super(driver);

	}

	public SQ2_7 familyMemberDateAndPlaceOfBirth(Properties data, String country) {

		if (!country.equalsIgnoreCase("na")) {
			relativeDOB = new DateTag(driver,
					"relative.whenFamilyMemberBorn.dateOfBirth");
			relativeDOB.selectDate(data.getProperty("DOB"));

			relativeAddress = new Address(driver,
					"applicationData-relative.whereFamilyMemberBorn.country");

			if (country.equalsIgnoreCase("insideUS")) {
				relativeAddress.setCountryDropDown(data
						.getProperty("DACA_Country"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				relativeAddress.setCountryDropDown(data.getProperty("Country"));
			}

			relativeAddress = new Address(driver,
					"applicationData-relative.whereFamilyMemberBorn");

			relativeAddress.setCity(data.getProperty("City"));

			if (country.equalsIgnoreCase("insideUS")) {
				relativeAddress.setState(data.getProperty("tripState"));
			}
			else if (country.equalsIgnoreCase("outsideUS")) {
				relativeAddress.setStateText(data.getProperty("State"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

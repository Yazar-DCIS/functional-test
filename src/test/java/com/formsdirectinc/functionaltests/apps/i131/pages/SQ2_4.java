package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4 extends WizardPage {
	private DateTag dob;
	private Address selectCountryOfBirth, SelectCountryOfCitizenShip;
	private YesNo countryOfCitizenShip;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 birthDetails(Properties data,
			String citizenshipCountrySameAsBirthCountry) {

		
		dob = new DateTag(driver, "applicant.birth.dateOfBirth");
		dob.selectMonth(data.getProperty("DOB_Month"));
		dob.selectDay(data.getProperty("DOB_Day"));
		dob.selectYear(data.getProperty("DOB_Year"));

		selectCountryOfBirth = new Address(driver,
				"applicationData-applicant.birth.countryOfBirth");
		selectCountryOfBirth
				.setCountryDropDown(data.getProperty("DOB_Country"));

		countryOfCitizenShip = new YesNo(driver,
				"applicant.citizenshipCountrySameAsBirthCountry");
	
		countryOfCitizenShip.setYesOrNo(citizenshipCountrySameAsBirthCountry);
		if (citizenshipCountrySameAsBirthCountry.equalsIgnoreCase("No")) {
			
			SelectCountryOfCitizenShip = new Address(driver,
					"applicationData-applicant.countryOfCitizenship");
			SelectCountryOfCitizenShip.setCountryDropDown(data
					.getProperty("I131_DOB_CitizenShipCountry"));
		}
		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}
}

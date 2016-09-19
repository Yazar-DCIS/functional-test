package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_4 extends WizardPage {

	private Address country;
	private DateTag dateOfBirth;
	private YesNo citizenship;
	private AdditionalInfoFields citizenshipCountry;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 setBiographicalInfo(Properties data,
			String otherCountryCitizenship) {
		dateOfBirth = new DateTag(driver, "applicantInfo.birth.dateOfBirth");

		country = new Address(driver,
				"applicationData-applicantInfo.birth.countryOfBirth");

		citizenship = new YesNo(driver, "applicantInfo.citizenOfOtherCountry");

		dateOfBirth.selectDate(data.getProperty("DOB"));

		country.setCountry(data.getProperty("DOB_Country"));

		if (otherCountryCitizenship.equalsIgnoreCase("Yes")) {
			citizenship.yes();

			citizenshipCountry = new AdditionalInfoFields(driver,

			"applicationData-applicantInfo.otherNationality");
			citizenshipCountry.normalText(data.getProperty("Country"));
		}

		else if (otherCountryCitizenship.equalsIgnoreCase("No")) {
			citizenship.no();
		}

		saveScreenShot("I102", "SQ2_4"); clickContinueInSQ();

		return this;
	}

}

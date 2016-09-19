package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5 extends WizardPage {

	private YesNo citizen;
	private Address country;

	public SQ1_5(WebDriver driver) {
		super(driver);

	}

	public SQ1_5 applicantCitizenship(String isUSCitizen, Properties data) {

		if (isUSCitizen.equalsIgnoreCase("yes")
				|| isUSCitizen.equalsIgnoreCase("no")) {

			citizen = new YesNo(driver, "applicant.usCitizenship");

			if (isUSCitizen.equalsIgnoreCase("No")) {
				citizen.no();
				setCountryOfCitizenship(data);
			} else if (isUSCitizen.equalsIgnoreCase("Yes")) {
				citizen.yes();
			}

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public void setCountryOfCitizenship(Properties data) {
		country = new Address(driver,
				"applicationData-applicant.countryOfCitizenship");
		country.setCountry(data.getProperty("Country"));
	}

}

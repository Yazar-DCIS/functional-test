package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;

/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5 extends com.formsdirectinc.functionaltests.tags.WizardPage {

	public DateTag dateTag;
	public Address dobCountry;

	public SQ1_5(WebDriver driver) {
		super(driver);

	}

	public SQ1_5 birthDetails(Properties data, String dob) {

		if (!dob.equalsIgnoreCase("NA")) {
			dateTag = new DateTag(driver, "applicant.dateOfBirth");
			if (dob.equalsIgnoreCase("beforeOct10_1952")) {
				dateTag.selectDateAsSingle(data.getProperty("preOct"));
			}

			else if (dob.equalsIgnoreCase("afterOct10_1952")) {
				dateTag.selectDateAsSingle(data.getProperty("DateOfBirth"));
			}

			dobCountry = new Address(driver,
					"applicationData-applicant.countryOfBirth");
			dobCountry.setCountry(data.getProperty("Country"));
			dobCountry = new Address(driver,
					"applicationData-applicant.nationality");
			dobCountry.setCountry(data.getProperty("Country"));

			saveScreenShot("n600", "SQ1_5"); clickContinueInSQ();
		}
		return this;
	}

}

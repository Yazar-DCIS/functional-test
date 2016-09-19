package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_4 extends WizardPage {

	private YesNo haveUsedPassport;
	private Country passportIssuedCountry;
	private DateTag passportIssuedDate, documentIssuedDate;
	private AdditionalInfoFields moreDetails;

	public SQ3_4(WebDriver driver) {
		super(driver);

	}

	public SQ3_4 entryIntoUS_part2(String havePassport, Properties data) {

		if (!havePassport.equalsIgnoreCase("NA")) {
			haveUsedPassport = new YesNo(driver,
					"applicant.additionalInfo.entryIntoUS.usePassport");

			if (havePassport.equalsIgnoreCase("Yes")) {
				haveUsedPassport.yes();
				passportIssuedCountry = new Country(driver,
						"applicationData-applicant.additionalInfo.entryIntoUS.countryIssue");
				passportIssuedCountry
						.setCountryDDM(data.getProperty("Country"));

				passportIssuedDate = new DateTag(driver,
						"applicant.additionalInfo.entryIntoUS.dateOfIssuanceForPassport");
				passportIssuedDate.selectDate(data.getProperty("DOB"));

				moreDetails = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.entryIntoUS");
				moreDetails.passportNumber(data.getProperty("ARN"));
			}

			else if (havePassport.equalsIgnoreCase("No")) {
				haveUsedPassport.no();
				moreDetails = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.entryIntoUS");
				moreDetails.documentName(data.getProperty("FirstName"));

				documentIssuedDate = new DateTag(driver,
						"applicant.additionalInfo.entryIntoUS.dateOfIssuanceForOtherDocument");
				documentIssuedDate.selectDate(data.getProperty("DOB"));

			}
			saveScreenShot("n600", "SQ3_4"); clickContinueInSQ();
		}
		return this;
	}

}

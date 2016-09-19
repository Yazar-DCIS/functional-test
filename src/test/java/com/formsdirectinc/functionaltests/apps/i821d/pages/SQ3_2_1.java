package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2_1 extends WizardPage {
	private YesNo haveTravelDoc;
	private AdditionalInfoFields passportNumber, borderCrossing;
	private Country passportIssuedCountry;
	private DateTag passportExpiryDate;

	public SQ3_2_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_2_1 applicantDontHaveTravelDoc(String havePassport,
			Properties data) throws Exception {

		if (!havePassport.equalsIgnoreCase("Skip")) {
			if (havePassport.equalsIgnoreCase("Yes")) {
				haveTravelDoc = new YesNo(driver,
						"applicant.travelDocument.havePassport");
				haveTravelDoc.yes();

				passportNumber = new AdditionalInfoFields(driver,

				"applicationData-applicant.travelDocument");
				passportNumber.passportNumber(data
						.getProperty("PassportNumber"));

				passportIssuedCountry = new Country(driver,
						"applicationData-applicant.travelDocument.issuedCountry");
				passportIssuedCountry.setCountryDDM(data
						.getProperty("DOB_Country"));

				passportExpiryDate = new DateTag(driver,
						"applicant.travelDocument.expireDate");
				passportExpiryDate.selectDateAsSingle(data
						.getProperty("expDate_DACA"));

				borderCrossing = new AdditionalInfoFields(driver,

				"applicationData-applicant.travelDocument.cardNumber");
				borderCrossing
						.isStatusOther(data.getProperty("PassportNumber"));
			}

			else if (havePassport.equalsIgnoreCase("No")) {
				haveTravelDoc = new YesNo(driver,
						"applicant.travelDocument.havePassport");
				haveTravelDoc.no();
			}

		}
		return this;
	}

}

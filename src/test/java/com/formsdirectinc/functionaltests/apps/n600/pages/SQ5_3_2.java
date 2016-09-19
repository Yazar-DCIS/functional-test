package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_3_2 extends WizardPage {

	protected DateTag naturalizationDate;
	protected AdditionalInfoFields naturalizationLocation;
	protected YesNo naturalizationPlace;
	protected Address naturalizationAddr;

	public SQ5_3_2(WebDriver driver) {
		super(driver);

	}

	public SQ5_3_2 naturalizationType(Properties data, String naturalizationType) {

		if (!naturalizationType.equalsIgnoreCase("NA")) {

			naturalizationDate = new DateTag(driver,
					"applicant.fatherInfo.naturalization.date");
			naturalizationDate.selectDate(data.getProperty("DOB"));

			naturalizationPlace = new YesNo(driver,
					"applicant.fatherInfo.hasCourtOrUcis");

			if (naturalizationType.equalsIgnoreCase("Court")) {
				naturalizationPlace.yes();

				naturalizationLocation = new AdditionalInfoFields(driver,

				"applicationData-applicant.fatherInfo.naturalization.nameOfCourt");
				naturalizationLocation.normalText(data
						.getProperty("USCIS_Office"));

				naturalizationAddr = new Address(driver,
						"applicationData-applicant.fatherInfo.naturalization");
				naturalizationAddr.setVisaCity(data.getProperty("tripCity"));
				naturalizationAddr.setState(data.getProperty("tripState"));

			}

			else if (naturalizationType.equalsIgnoreCase("USCIS_Office")) {
				naturalizationPlace.no();
				naturalizationLocation = new AdditionalInfoFields(driver,

				"applicationData-applicant.fatherInfo.naturalization.location");
				naturalizationLocation.normalText(data
						.getProperty("USCIS_Office"));

			}
			saveScreenShot("n600", "SQ5_3_2"); clickContinueInSQ();
		}
		return this;
	}

}

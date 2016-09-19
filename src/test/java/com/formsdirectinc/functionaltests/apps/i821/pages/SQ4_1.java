package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	
	private CommonInputClasses currentSpouseName;
	private DateTag dateOfBirth;
	private DateTag dateOfMarriage;
	private Address placeOfMarriage;
	private AdditionalInfoFields spouseArn;
	private AdditionalInfoFields spouseElisNumber;

	public SQ4_1 about_Spouse(String spouse, Properties data) {
		if (!spouse.equalsIgnoreCase("NA")) {
			if (spouse.equalsIgnoreCase("MARRIED")) {

				currentSpouseName = new CommonInputClasses(driver);
				currentSpouseName.applicantNameDetails(
						"currentSpouseDetails.currentSpouseName", data);

				dateOfBirth = new DateTag(driver,
						"currentSpouseDetails.dateOfBirth");
				dateOfBirth.selectDateAsSingle(data.getProperty("DOB"));

				dateOfMarriage = new DateTag(driver,
						"currentSpouseDetails.dateOfMarriage");
				dateOfMarriage.selectDateAsSingle(data
						.getProperty("dateOfMarriage"));

				placeOfMarriage = new Address(driver,
						"applicationData-currentSpouseDetails.placeOfMarriage.country");
				placeOfMarriage.setCountry(data.getProperty("DACA_Country"));

				placeOfMarriage = new Address(driver,
						"applicationData-currentSpouseDetails.placeOfMarriage");
				placeOfMarriage.setCity(data.getProperty("tripCity0"));
				placeOfMarriage.setState(data.getProperty("tripState"));

				spouseArn = new AdditionalInfoFields(driver,
						"applicationData-currentSpouseDetails.spouseArn");
				spouseArn.normalText(data.getProperty("ARN"));

				spouseElisNumber = new AdditionalInfoFields(driver,

				"applicationData-currentSpouseDetails.spouseElisNumber");
				spouseElisNumber.normalText(data.getProperty("ELIS"));

				saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();

			}
		}

		return this;
	}
}

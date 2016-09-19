package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_1 extends WizardPage {

	private Address ForeignCountryDD;
	private Name_FirstMiddleLast nameofOfficial;
	private AdditionalInfoFields titleofOfficial;
	private AdditionalInfoFields nameOfGovtAgency;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 govt_AgencyDetails(String agency_Details, Properties data) {
		if (!agency_Details.equalsIgnoreCase("NA")) {
			ForeignCountryDD = new Address(driver,
					"applicationData-formSpecific.nameOfForeignCountry");
			ForeignCountryDD
					.setCountryDropDown(data.getProperty("DOB_Country"));
			
			// name of Official requesting this certificate
			nameofOfficial=new Name_FirstMiddleLast(driver, "applicationData", "formSpecific.nameOfOfficial");
			nameofOfficial.setFirstNameField(data.getProperty("FirstName"));
			nameofOfficial.setLastNameField(data.getProperty("LastName"));
			nameofOfficial.setMiddleNameField(data.getProperty("MiddleName"));
			
			// title of Official requesting this certificate
			titleofOfficial = new AdditionalInfoFields(driver,
			"applicationData-formSpecific.titleOfOfficial");
			titleofOfficial.normalText(data.getProperty("DOB_Country"));

			// Government Agency
			nameOfGovtAgency = new AdditionalInfoFields(driver,
			"applicationData-formSpecific.nameOfGovtAgency");
			nameOfGovtAgency.normalText(data.getProperty("DOB_Country"));

			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

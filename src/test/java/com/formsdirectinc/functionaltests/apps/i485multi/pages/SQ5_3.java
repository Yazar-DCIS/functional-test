package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_3 extends WizardPage {

	
	

	private Country spouseCountry;
	private AdditionalInfoFields spouseCity;
	private DateTag dateOfMarriage;

	public SQ5_3(WebDriver driver) {
		super(driver);

	}

	public void marriageInformations(Properties data) {

		dateOfMarriage = new DateTag(driver,
				"principalFamilyMembers.spouseInfo.dateOfMarriage");
		dateOfMarriage.selectDate(data.getProperty("dateOfMarriages"));

		spouseCity = new AdditionalInfoFields(driver,
				"applicationData-principalFamilyMembers.spouseInfo.spousePlaceOfMarriage-city");
		spouseCity.normalText(data.getProperty("City"));

		spouseCountry = new Country(
				driver,
				"applicationData-principalFamilyMembers.spouseInfo.spousePlaceOfMarriage.country");
		spouseCountry.setCountryDDM(data.getProperty("Country"));

	}

}

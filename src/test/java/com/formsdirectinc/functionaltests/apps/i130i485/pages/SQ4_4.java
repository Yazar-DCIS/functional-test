package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_4 extends WizardPage {

	private DateTag dateOfBirth;
	private Address birthPlace;
	private Country birthCountry;

	public SQ4_4(WebDriver driver) {
		super(driver);
	}

	public SQ4_4 birthInformation() {
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		
		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(i130i485.getProperty("applicant.birth.dateOfBirth"));

		birthPlace = new Address(driver, "applicationData-applicant.birth");
		birthPlace.setCityOfBirth(i130i485.getProperty("applicant.birth.city"));
		
		birthCountry=new Country(driver, "applicationData-applicant.birth");
		birthCountry.setBirthCountry(i130i485.getProperty("applicant.birth.country"));

		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ7_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_4 extends WizardPage {

	private YesNo usedRomanLetters;
	private Address addressInfo;
	private DateTag dateOfBirth;
	private Country countryInfo;
	
	public SQ7_4(WebDriver driver) {
		super(driver);
	}

	public SQ7_4 relativeBiographicInfo(String useRomanLetters) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		dateOfBirth = new DateTag(driver, "foreignRelative.birth.dateOfBirth");
		dateOfBirth.selectDate(i130i485.getProperty("foreignRelative.birth.dateOfBirth"));

		addressInfo = new Address(driver,"applicationData-foreignRelative.birth");
		addressInfo.setCityOfBirth(i130i485.getProperty("foreignRelative.birth.city"));
		addressInfo.setStateOfBirth(i130i485.getProperty("foreignRelative.birth.state"));

		countryInfo = new Country(driver,"applicationData-foreignRelative.birth");
		countryInfo.setBirthCountry(i130i485.getProperty("foreignRelative.birth.country"));
		
		countryInfo = new Country(driver,"applicationData-foreignRelative");
		countryInfo.setCitizenshipCountry(i130i485.getProperty("foreignRelative.citizenship.country"));
		
		usedRomanLetters = new YesNo(driver, "foreignRelative.useRomanLetters");
		usedRomanLetters.setYesOrNo(useRomanLetters);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

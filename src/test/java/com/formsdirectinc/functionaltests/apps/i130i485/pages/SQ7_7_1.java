package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_7_1 extends WizardPage {

	private Numbers visaNumber;
	private Address visaAddress;
	private DateTag visaDate;

	public SQ7_7_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_7_1 relativeVisaNumber() {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		visaNumber = new Numbers(driver,"applicationData-foreignRelative.nonImmigrantVisa");
		visaNumber.setVisaNumber(i130i485.getProperty("foreignRelative.nonImmigrantVisa.visaNumber"));
		
		visaAddress=new Address(driver, "applicationData-foreignRelative.nonImmigrantVisa.placeVisaIssued");
		visaAddress.setCity(i130i485.getProperty("foreignRelative.nonImmigrantVisa.placeVisaIssued.city"));
		visaAddress.setCountryField(i130i485.getProperty("foreignRelative.nonImmigrantVisa.placeVisaIssued.country"));
		
		visaDate=new DateTag(driver, "foreignRelative.nonImmigrantVisa.dateVisaIssued");
		visaDate.selectDateAsSingle(i130i485.getProperty("foreignRelative.nonImmigrantVisa.dateVisaIssued"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

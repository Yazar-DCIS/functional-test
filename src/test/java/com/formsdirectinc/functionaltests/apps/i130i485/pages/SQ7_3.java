package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ7_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_3 extends WizardPage {

	public SQ7_3(WebDriver driver) {
		super(driver);
	}

	public SQ7_3 relativeForeignAddressDetails(String country) {

		
		String appname=Products.I130I485.name().toLowerCase();
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		Address relativeAddress=new Address(driver);
		relativeAddress.setAddress(appname, "foreignRelative.foreignAddress",country);
	
		PhoneNumber foreignRelativeNumber=new PhoneNumber(driver, "applicationData","foreignRelative.foreignPhone");
		foreignRelativeNumber.setPhoneCountryOptions(i130i485.getProperty("foreignRelative.foreignPhone.country"));
		foreignRelativeNumber.setAddnPhoneNumber(i130i485.getProperty("foreignRelative.foreignPhone.phone3"));

		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

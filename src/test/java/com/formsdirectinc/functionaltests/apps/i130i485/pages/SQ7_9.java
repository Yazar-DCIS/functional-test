package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_9 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_9 extends WizardPage {

	private Address presenceAddress;

	public SQ7_9(WebDriver driver) {
		super(driver);
	}

	public SQ7_9 relativePresenceInUS() {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		presenceAddress = new Address(driver,"applicationData-foreignRelative.presenceInUS");
		presenceAddress.setCity(i130i485.getProperty("foreignRelative.presenceInUS.city"));
		presenceAddress.setCountryField(i130i485.getProperty("foreignRelative.presenceInUS.country"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

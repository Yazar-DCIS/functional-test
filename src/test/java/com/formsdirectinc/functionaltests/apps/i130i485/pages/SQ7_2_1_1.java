package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_2_1_1 extends WizardPage {

	private DateTag dateMoveToCurrentAddress3;
	private PhoneNumber foreignRelativeNumber;

	public SQ7_2_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_2_1_1 relativeAddressInfo(String dateMoveToCurrentAddress) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		
		dateMoveToCurrentAddress3 = new DateTag(driver,
				"foreignRelative.dateMoveToCurrentAddress3");
		dateMoveToCurrentAddress3.selectDate(dateMoveToCurrentAddress);
		
		foreignRelativeNumber = new PhoneNumber(driver,
				"applicationData-foreignRelative.phone3");
		foreignRelativeNumber.setPhoneCode(i130i485.getProperty("foreignRelative.phone3.phone1"));
		foreignRelativeNumber.setPhoneNumber(i130i485.getProperty("foreignRelative.phone3.phone2"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

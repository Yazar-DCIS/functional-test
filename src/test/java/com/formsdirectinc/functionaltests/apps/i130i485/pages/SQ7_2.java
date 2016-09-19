package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_2 extends WizardPage {

	private DateTag dateStartLivingTogether,dateMoveToCurrentAddress1;;
	private PhoneNumber foreignRelativeNumber;

	public SQ7_2(WebDriver driver) {
		super(driver);
	}

	public SQ7_2 relativeAddressInfo(String dateMoveToCurrentAddress) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		dateStartLivingTogether = new DateTag(driver,
				"foreignRelative.dateStartLivingTogether");
		dateStartLivingTogether.selectDate(i130i485.getProperty("foreignRelative.dateStartLivingTogether"));
		
		dateMoveToCurrentAddress1 = new DateTag(driver,
				"foreignRelative.dateMoveToCurrentAddress1");
		dateMoveToCurrentAddress1.selectDate(dateMoveToCurrentAddress);

		foreignRelativeNumber = new PhoneNumber(driver,
				"applicationData-foreignRelative.phone1");
		foreignRelativeNumber.setPhoneCode(i130i485.getProperty("foreignRelative.phone1.phone1"));
		foreignRelativeNumber.setPhoneNumber(i130i485.getProperty("foreignRelative.phone1.phone2"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.ClassOfAdmission;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_8 extends WizardPage {

	private ClassOfAdmission coaDetails;
	
	public SQ7_8(WebDriver driver) {
		super(driver);
	}

	public SQ7_8 relativeAdmissionStatus(String coaValidIndefinitely) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		coaDetails = new ClassOfAdmission(driver,"foreignRelative.classOfAdmissionCurrentStatus");
		coaDetails.setClassOfAdmissionManner(i130i485.getProperty("foreignRelative.classOfAdmissionCurrentStatus.manner"));
		coaDetails.setClassOfAdmissionCurrentStatus(i130i485.getProperty("foreignRelative.classOfAdmissionCurrentStatus.status"));
		
		if(coaValidIndefinitely.equalsIgnoreCase("Yes"))
		{
			coaDetails.setClassOfAdmissionValidity();
		}
		else if(coaValidIndefinitely.equalsIgnoreCase("No"))
		{
			DateTag statusExpriryDate=new DateTag(driver, "foreignRelative.classOfAdmissionCurrentStatus.statusExpire");
			statusExpriryDate.selectDate(i130i485.getProperty("foreignRelative.classOfAdmissionCurrentStatus.statusExpire"));
			
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

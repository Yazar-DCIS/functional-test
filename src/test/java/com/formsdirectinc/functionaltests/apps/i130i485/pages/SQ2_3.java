package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	private MaritalInfo maritalStatus;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public SQ2_3 citizenshipMaritaLStatus(String maritalType) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		maritalStatus = new MaritalInfo(driver,"applicationData-applicant.maritalStatus");
		maritalStatus.setMarriageStatus(i130i485.getProperty("applicant.maritalStatus."+maritalType));
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

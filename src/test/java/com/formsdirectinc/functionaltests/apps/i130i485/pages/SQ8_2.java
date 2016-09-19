package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ8_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ8_2 extends WizardPage {

	private MaritalInfo maritalStatusInfo;

	public SQ8_2(WebDriver driver) {
		super(driver);
	}

	public SQ8_2 relativeMaritalStatus(String maritalStatus) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		if(maritalStatus.equalsIgnoreCase("Single")||maritalStatus.equalsIgnoreCase("Married")
				||maritalStatus.equalsIgnoreCase("Widowed")||maritalStatus.equalsIgnoreCase("Divorced"))
		{
		maritalStatusInfo = new MaritalInfo(driver,"applicationData-foreignRelative.maritalStatus");
		maritalStatusInfo.setMarriageStatus(i130i485.getProperty("foreignRelative.maritalStatus."+maritalStatus));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ8_3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ8_3_2 extends WizardPage {

	private MaritalInfo maritalStatusInfo;

	public SQ8_3_2(WebDriver driver) {
		super(driver);
	}

	public SQ8_3_2 relativeOtherMaritalStatus(String maritalStatus) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(maritalStatus.equalsIgnoreCase("widowed")||maritalStatus.equalsIgnoreCase("divorced"))
		{
		maritalStatusInfo = new MaritalInfo(driver,"applicationData-foreignRelative.otherMaritalStatus");
		maritalStatusInfo.setMarriageStatus(i130i485.getProperty("foreignRelative.otherMaritalStatus."+maritalStatus));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Parents;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ8_1 extends WizardPage {

	
	public SQ8_1(WebDriver driver) {
		super(driver);
	}

	public SQ8_1 relativeParentsInfo(String fatherStillAlive,String motherStillAlive) {

		String appname=Products.I130I485.name().toLowerCase();
		Parents applicantParentInfo=new Parents(driver);
		applicantParentInfo.parentsInformation(appname, "foreignRelative", fatherStillAlive, motherStillAlive);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

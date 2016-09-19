package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Parents;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_8 extends WizardPage {

	
	public SQ4_8(WebDriver driver) {
		super(driver);
	}

	public SQ4_8 parentsInformation(String fatherStillAlive,String motherStillAlive) {
		
		String appname=Products.I130I485.name().toLowerCase();
		if(fatherStillAlive.equalsIgnoreCase("yes")||fatherStillAlive.equalsIgnoreCase("no")
				||motherStillAlive.equalsIgnoreCase("yes")||motherStillAlive.equalsIgnoreCase("no"))
		{
		Parents applicantParentInfo=new Parents(driver);
		applicantParentInfo.parentsInformation(appname, "applicant", fatherStillAlive, motherStillAlive);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

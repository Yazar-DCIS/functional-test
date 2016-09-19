package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_4 extends WizardPage {

	
	public SQ10_4(WebDriver driver) {
		super(driver);
	}

	
	
	public SQ10_4 relativeInformationRelatedToCrimeIntent(String haveEspionage,
			String oppostionToGov,String haveEvade) {

	
		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.haveEspionage", haveEspionage);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.oppostionToGov", oppostionToGov);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.haveEvade", haveEvade);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

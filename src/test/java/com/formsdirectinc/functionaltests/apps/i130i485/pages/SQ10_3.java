package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ10_3 extends WizardPage {

	
	public SQ10_3(WebDriver driver) {
		super(driver);
	}

	
	
	public SQ10_3 relativeInformationRelatedToCrimeHistory(String procuredForProstitution,
			String anyUnlawfulAct,String knowinglyEncourage,String illicitlyTraffic) {

	
		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.procuredForProstitution", procuredForProstitution);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.anyUnlawfulAct", anyUnlawfulAct);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.knowinglyEncourage", knowinglyEncourage);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.illicitlyTraffic", illicitlyTraffic);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

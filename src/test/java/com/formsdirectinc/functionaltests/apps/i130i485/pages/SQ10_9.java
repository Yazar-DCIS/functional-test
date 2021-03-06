package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_9 extends WizardPage {

	
	public SQ10_9(WebDriver driver) {
		super(driver);
	}

	public SQ10_9 relativeWeaponRelatedInfo(String sellingWeapons,
			String receivedWeaponsTraining) {

		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.sellingWeapons", sellingWeapons);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.receivedWeaponsTraining", receivedWeaponsTraining);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

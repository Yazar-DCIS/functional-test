package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_8 extends WizardPage {

	public SQ10_8(WebDriver driver) {
		super(driver);
	}

	public SQ10_8 relativePrisonServices(String servedInMilitary,
			String servedInJail,String weaponAgainstPerson) {

		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.servedInMilitary", servedInMilitary);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.servedInJail", servedInJail);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.weaponAgainstPerson", weaponAgainstPerson);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_5_1 extends WizardPage {

	
	public SQ10_5_1(WebDriver driver) {
		super(driver);
	}

	public SQ10_5_1 relativeOtherActs(String engageInGenocide,
			String killingAnyPerson,String injuredAnyPerson,String engageSexualContact,String denyAnyoneReligiousBeliefs) {

		
		String appname=Products.I130I485.name().toLowerCase();
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.engageInGenocide", engageInGenocide);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.killingAnyPerson", killingAnyPerson);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.injuredAnyPerson", injuredAnyPerson);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.engageSexualContact", engageSexualContact);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.denyAnyoneReligiousBeliefs", denyAnyoneReligiousBeliefs);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

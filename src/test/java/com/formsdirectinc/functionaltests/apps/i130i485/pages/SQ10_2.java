package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ10_2 extends WizardPage {

	

	public SQ10_2(WebDriver driver) {
		super(driver);
	}

	public SQ10_2 relativeInformationRelatedToCrimeHistory(String anyMoralTurpitude,
			String haveArrest,String benefitOfPardon,String anycriminalOffense) {

	
		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.anyMoralTurpitude", anyMoralTurpitude);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.haveArrest", haveArrest);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.benefitOfPardon", benefitOfPardon);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.anycriminalOffense", anycriminalOffense);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

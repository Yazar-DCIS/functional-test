package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_5 extends WizardPage {

	public SQ10_5(WebDriver driver) {
		super(driver);
	}

	public SQ10_5 relativeInformationRelatedToMiscellaneous(String anyPublicAssist,
			String conspireToEngage,String communistParty) {

		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.anyPublicAssist", anyPublicAssist);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.conspireToEngage", conspireToEngage);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.communistParty", communistParty);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

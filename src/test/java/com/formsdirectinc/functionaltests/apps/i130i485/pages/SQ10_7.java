package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_7 extends WizardPage {

	
	public SQ10_7(WebDriver driver) {
		super(driver);
	}

	public SQ10_7 relativeOtherViolations(String orderOfCivilpenalty,
			String grantCustody,String naziGovt,String practicePolygamy) {

		String appname=Products.I130I485.name().toLowerCase();
		
		CrimeDetails crimes=new CrimeDetails(driver);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.orderOfCivilpenalty", orderOfCivilpenalty);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.grantCustody", grantCustody);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.naziGovt", naziGovt);
		crimes.informationRelatedToCrime(appname, "foreignRelative.processInfo.practicePolygamy", practicePolygamy);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

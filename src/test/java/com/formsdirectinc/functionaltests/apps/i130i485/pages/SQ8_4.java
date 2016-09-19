package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.PreviousSpouse;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ8_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ8_4 extends WizardPage {

	
	public SQ8_4(WebDriver driver) {
		super(driver);
	}

	public SQ8_4 relativePriorMarriagesInfo(int previousMrgCount) {

		String appname=Products.I130I485.name().toLowerCase();
		if(previousMrgCount>0)
		{
		PreviousSpouse applicantPriorMarriagesInfo=new PreviousSpouse(driver);
		applicantPriorMarriagesInfo.priorMarriageInformation("foreignRelative.previousSpouse", appname, previousMrgCount);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

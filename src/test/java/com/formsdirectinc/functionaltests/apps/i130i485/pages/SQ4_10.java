package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.PreviousSpouse;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ4_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_10 extends WizardPage {


	public SQ4_10(WebDriver driver) {
		super(driver);
	}

	public SQ4_10 priorMarriage(int previousMrgCount) {
		
		String appName = Products.I130I485.name().toLowerCase();
		if(previousMrgCount>0)
		{
		PreviousSpouse previousSpouseInfo=new PreviousSpouse(driver);
		previousSpouseInfo.priorMarriageInformation("applicant.previousSpouse",appName, previousMrgCount);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

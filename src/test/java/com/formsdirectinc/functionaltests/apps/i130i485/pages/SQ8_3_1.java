package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ8_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ8_3_1 extends WizardPage {

	
	public SQ8_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ8_3_1 relativePriorMarriageInfo(String marriedBefore) {

		if(marriedBefore.equalsIgnoreCase("Yes")||marriedBefore.equalsIgnoreCase("no"))
		{
		YesNo applicantPriorMarriage=new YesNo(driver, "foreignRelative.marriedBefore");
		applicantPriorMarriage.setYesOrNo(marriedBefore);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		
		return this;
	}

}

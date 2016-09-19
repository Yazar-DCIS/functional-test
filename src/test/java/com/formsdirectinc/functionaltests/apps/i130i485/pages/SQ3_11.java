package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_11 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_11 extends WizardPage {

	private YesNo legitimation;

	public SQ3_11(WebDriver driver) {
		super(driver);
	}

	public SQ3_11 relativeLegitimated(String relativeLegitimated) {
		
		if(relativeLegitimated.equalsIgnoreCase("Yes")||relativeLegitimated.equalsIgnoreCase("no"))
		{
		legitimation = new YesNo(driver, "applicant.relativeLegitimated");
		legitimation.setYesOrNo(relativeLegitimated);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

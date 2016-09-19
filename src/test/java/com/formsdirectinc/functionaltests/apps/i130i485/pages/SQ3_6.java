package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_6 extends WizardPage {

	private YesNo legitimation;

	public SQ3_6(WebDriver driver) {
		super(driver);
	}

	public SQ3_6 legitimated(String legitimated) {
		if(legitimated.equalsIgnoreCase("Yes")||legitimated.equalsIgnoreCase("no"))
		{
		legitimation = new YesNo(driver, "applicant.legitimated");
		legitimation.setYesOrNo(legitimated);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		}
		return this;
	}

}

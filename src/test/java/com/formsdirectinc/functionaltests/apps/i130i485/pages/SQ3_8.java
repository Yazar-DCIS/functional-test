package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_8 extends WizardPage {

	private YesNo stepparentMarriedNaturalparent;

	public SQ3_8(WebDriver driver) {
		super(driver);
	}

	public SQ3_8 stepParentMarriedNaturalParent(String stepParentMarriedNaturalparent) {
		
		if(stepParentMarriedNaturalparent.equalsIgnoreCase("Yes")||stepParentMarriedNaturalparent.equalsIgnoreCase("no"))
		{
		stepparentMarriedNaturalparent = new YesNo(driver, "applicant.stepparentMarriedNaturalparent");
		stepparentMarriedNaturalparent.setYesOrNo(stepParentMarriedNaturalparent);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_5 extends WizardPage {

	private YesNo marriageHappenedBeforeBirth;

	public SQ3_5(WebDriver driver) {
		super(driver);
	}

	public SQ3_5 parentsMarriedBeforeYourBirth(String parentsMarriedBeforeYourBirth) {
		
		if(parentsMarriedBeforeYourBirth.equalsIgnoreCase("Yes")||parentsMarriedBeforeYourBirth.equalsIgnoreCase("no"))
		{
		marriageHappenedBeforeBirth = new YesNo(driver, "applicant.parentsMarriedBeforeBorn");
		marriageHappenedBeforeBirth.setYesOrNo(parentsMarriedBeforeYourBirth);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

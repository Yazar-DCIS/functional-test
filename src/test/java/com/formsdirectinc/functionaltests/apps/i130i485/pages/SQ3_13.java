package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_13 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_13 extends WizardPage {

	private YesNo relativeUnmarriedUnderAge;

	public SQ3_13(WebDriver driver) {
		super(driver);
	}

	public SQ3_13 relativeUnmarriedUnderAge(String wasRelativeUnmarriedUnderAge) {
		
		if(wasRelativeUnmarriedUnderAge.equalsIgnoreCase("Yes")||wasRelativeUnmarriedUnderAge.equalsIgnoreCase("No"))
		{
		relativeUnmarriedUnderAge = new YesNo(driver, "applicant.marriedStepChildrensParent");
		relativeUnmarriedUnderAge.setYesOrNo(wasRelativeUnmarriedUnderAge);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

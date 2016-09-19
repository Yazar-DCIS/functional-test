package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_9 extends WizardPage {

	private YesNo relativeUnmarriedUnderAge;

	public SQ3_9(WebDriver driver) {
		super(driver);
	}

	public SQ3_9 relativeUnmarriedUnderAge(String wasRelativeUnmarriedUnderAge) {
		
		if(wasRelativeUnmarriedUnderAge.equalsIgnoreCase("Yes")||wasRelativeUnmarriedUnderAge.equalsIgnoreCase("no"))
		{
		relativeUnmarriedUnderAge = new YesNo(driver, "applicant.relativeUnmarriedUnderAge");
		relativeUnmarriedUnderAge.setYesOrNo(wasRelativeUnmarriedUnderAge);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

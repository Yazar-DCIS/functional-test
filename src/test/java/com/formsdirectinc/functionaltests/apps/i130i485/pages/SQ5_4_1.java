package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_4_1 extends WizardPage {

	private YesNo relativeOverAged;

	public SQ5_4_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_4_1 relativeAge(String relativeAgedAbove18) {

		if(relativeAgedAbove18.equalsIgnoreCase("Yes")||relativeAgedAbove18.equalsIgnoreCase("no"))
		{
		relativeOverAged = new YesNo(driver, "applicant.sponsorInfo.relativeOverAged");
		relativeOverAged.setYesOrNo(relativeAgedAbove18);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

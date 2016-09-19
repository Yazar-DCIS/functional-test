package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_4 extends WizardPage {

	private YesNo servedInMilitary;

	public SQ5_4(WebDriver driver) {
		super(driver);
	}

	public SQ5_4 militaryService(String servedMilitary) {

		if(servedMilitary.equalsIgnoreCase("Yes")||servedMilitary.equalsIgnoreCase("no"))
		{
		servedInMilitary = new YesNo(driver, "applicant.sponsorInfo.usArmy");
		servedInMilitary.setYesOrNo(servedMilitary);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

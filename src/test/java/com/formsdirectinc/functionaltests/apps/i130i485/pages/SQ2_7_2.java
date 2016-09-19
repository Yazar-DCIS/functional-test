package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7_2 extends WizardPage {

	private YesNo spouseObtainPermanentResidency;

	public SQ2_7_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_7_2 spouseObtainPermanentResidency(String spouseObtainPermanentResidencyStatus) {
		
		if(spouseObtainPermanentResidencyStatus.equalsIgnoreCase("Yes")||spouseObtainPermanentResidencyStatus.equalsIgnoreCase("no"))
		{
		spouseObtainPermanentResidency=new YesNo(driver,"applicant.spouseObtainPermanentResidency");
		spouseObtainPermanentResidency.setYesOrNo(spouseObtainPermanentResidencyStatus);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

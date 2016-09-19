package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_8 extends WizardPage {

	private YesNo gainImmigrationStatusAdoption;

	public SQ2_8(WebDriver driver) {
		super(driver);
	}

	public SQ2_8 gainImmigrationStatusAdoption(String gainImmigrationStatus) {
		
		if(gainImmigrationStatus.equalsIgnoreCase("Yes")||gainImmigrationStatus.equalsIgnoreCase("no"))
		{
		gainImmigrationStatusAdoption=new YesNo(driver,"applicant.gainImmigrationStatusAdoption");
		gainImmigrationStatusAdoption.setYesOrNo(gainImmigrationStatus);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

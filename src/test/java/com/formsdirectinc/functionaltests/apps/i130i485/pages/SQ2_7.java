package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {

	private YesNo gainImmigrationStatusAtWedding;

	public SQ2_7(WebDriver driver) {
		super(driver);
	}

	public SQ2_7 gainImmigrationStatusMarriage(String gainImmigrationStatus) {
		
		if(gainImmigrationStatus.equalsIgnoreCase("yes")||gainImmigrationStatus.equalsIgnoreCase("no"))
		{
		gainImmigrationStatusAtWedding=new YesNo(driver, "applicant.gainImmigrationStatusMarriage");
		gainImmigrationStatusAtWedding.setYesOrNo(gainImmigrationStatus);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

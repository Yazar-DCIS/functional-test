package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	private YesNo adopted;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 bothRelatedByAdoption(String bothRelatedByAdoption) {
		
		if(bothRelatedByAdoption.equalsIgnoreCase("Yes")||bothRelatedByAdoption.equalsIgnoreCase("no"))
		{
		adopted = new YesNo(driver, "applicant.bothRelatedByAdoption");
		adopted.setYesOrNo(bothRelatedByAdoption);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

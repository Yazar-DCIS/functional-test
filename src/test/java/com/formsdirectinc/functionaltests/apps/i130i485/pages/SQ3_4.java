package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_4 extends WizardPage {

	private MultiRadioOptions parentInfo;

	public SQ3_4(WebDriver driver) {
		super(driver);
	}

	public SQ3_4 applyingForRelation(String relationshipIs) {
		
		
		if(relationshipIs.equalsIgnoreCase("biofather")||relationshipIs.equalsIgnoreCase("biomother")
				||relationshipIs.equalsIgnoreCase("stepfather")||relationshipIs.equalsIgnoreCase("stepmother"))
		{
		parentInfo = new MultiRadioOptions(driver,
				"applicationData-applicant.applyingFor");
		
		if(relationshipIs.equalsIgnoreCase("biofather"))
		{
			parentInfo.selectOption(1);
		}
		else if(relationshipIs.equalsIgnoreCase("biomother"))
		{
			parentInfo.selectOption(2);
		}
		else if(relationshipIs.equalsIgnoreCase("stepfather"))
		{
			parentInfo.selectOption(3);
		}
		else if(relationshipIs.equalsIgnoreCase("stepmother"))
		{
			parentInfo.selectOption(4);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

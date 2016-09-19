package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_10 extends WizardPage {

	private MultiRadioOptions relativeRelationship;

	public SQ3_10(WebDriver driver) {
		super(driver);
	}

	public SQ3_10 relativeRelationship(String relationshipIs) {
		
		if(relationshipIs.equalsIgnoreCase("biofather")||relationshipIs.equalsIgnoreCase("biomother")
				||relationshipIs.equalsIgnoreCase("stepfather")||relationshipIs.equalsIgnoreCase("stepmother"))
		{
		
		relativeRelationship = new MultiRadioOptions(driver,
				"applicationData-applicant.relativeRelationship");
		
		if(relationshipIs.equalsIgnoreCase("biofather"))
		{
			relativeRelationship.selectOption(1);
		}
		else if(relationshipIs.equalsIgnoreCase("biomother"))
		{
			relativeRelationship.selectOption(2);
		}
		else if(relationshipIs.equalsIgnoreCase("stepfather"))
		{
			relativeRelationship.selectOption(3);
		}
		else if(relationshipIs.equalsIgnoreCase("stepmother"))
		{
			relativeRelationship.selectOption(4);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

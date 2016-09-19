package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4 extends WizardPage {

	private MultiRadioOptions relationship;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 applicantRelationType1(String relation) {
		
		
		if(relation.equalsIgnoreCase("spouse")
				||relation.equalsIgnoreCase("parent")
				||relation.equalsIgnoreCase("child"))
		{	
		
		relationship = new MultiRadioOptions(driver,
				"applicationData-applicant.relationshipType1");
		
		if(relation.equalsIgnoreCase("spouse"))
		{
			relationship.selectOption(1);
		}
		else if(relation.equalsIgnoreCase("parent"))
		{
			relationship.selectOption(2);
		}
		else if(relation.equalsIgnoreCase("child"))
		{
			relationship.selectOption(3);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

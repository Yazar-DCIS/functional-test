package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_5 extends WizardPage {

	private MultiRadioOptions relationship;

	public SQ2_5(WebDriver driver) {
		super(driver);
	}

	public SQ2_5 applicantRelationType2(String relation) {
		
		if(relation.equalsIgnoreCase("parent")||relation.equalsIgnoreCase("child"))
		{
		relationship = new MultiRadioOptions(driver,
				"applicationData-applicant.relationshipType2");
		if(relation.equalsIgnoreCase("parent"))
		{
			relationship.selectOption(1);
		}
		else if(relation.equalsIgnoreCase("child"))
		{
			relationship.selectOption(2);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

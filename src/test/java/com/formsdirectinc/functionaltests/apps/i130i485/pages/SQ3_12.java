package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_12 extends WizardPage {

	private YesNo ongoingRelationshipRelative;

	public SQ3_12(WebDriver driver) {
		super(driver);
	}

	public SQ3_12 relativeOngoingRelationship(String ongoingRelationshipOfRelative) {
		
		if(ongoingRelationshipOfRelative.equalsIgnoreCase("Yes")||ongoingRelationshipOfRelative.equalsIgnoreCase("no"))
		{
		ongoingRelationshipRelative = new YesNo(driver, "applicant.ongoingRelationshipRelative");
		ongoingRelationshipRelative.setYesOrNo(ongoingRelationshipOfRelative);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

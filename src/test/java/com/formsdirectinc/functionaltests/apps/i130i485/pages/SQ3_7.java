package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_7 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_7 extends WizardPage {

	private YesNo ongoingRelationshipFather;

	public SQ3_7(WebDriver driver) {
		super(driver);
	}

	public SQ3_7 ongoingRelationship(String ongoingRelationshipWithFather) {
		
		if(ongoingRelationshipWithFather.equalsIgnoreCase("Yes")||ongoingRelationshipWithFather.equalsIgnoreCase("no"))
		{
		ongoingRelationshipFather = new YesNo(driver, "applicant.ongoingRelationshipFather");
		ongoingRelationshipFather.setYesOrNo(ongoingRelationshipWithFather);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

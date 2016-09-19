package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_1 extends WizardPage {

	
	

	private CheckBox membership;

	public SQ6_1(WebDriver driver) {
		super(driver);

	}

	public void membershipDetails(String type) {

		membership = new CheckBox(driver, "applicationData-" + type
				+ "FormSpecific.processingInfo.hasMembershipInPast");
		membership.check();

	}

}

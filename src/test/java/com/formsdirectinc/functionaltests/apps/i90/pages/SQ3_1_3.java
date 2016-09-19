package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: You must wait to file your application
 *@author Orina
 */

public class SQ3_1_3 extends WizardPage {


	public SQ3_1_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_3 waitToFileApplication(String visitThisPage) {
	
		if (visitThisPage.equalsIgnoreCase("yes")) {

			CheckBox waitToFileApplication = new CheckBox(driver,
					"applicationData-formSpecific.waitToFileApplication");

			waitToFileApplication.check();
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}

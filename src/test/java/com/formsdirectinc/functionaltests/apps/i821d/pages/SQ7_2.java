package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_2 extends WizardPage {
	private CheckBox certification;

	public SQ7_2(WebDriver driver) {
		super(driver);
	}

	public SQ7_2 certification() throws Exception {
		certification = new CheckBox(driver,
				"applicationData-interpreterInformation.declaration");
		certification.check();

		return this;
	}

}

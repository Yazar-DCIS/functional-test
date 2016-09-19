package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_1 extends WizardPage {

	private CheckBox validCheck;

	public SQ6_1(WebDriver driver) {
		super(driver);
	}

	public SQ6_1 pastMembership(Properties data) {

		validCheck = new CheckBox(driver,
				"applicationData-processingInfo.pastMembership");
		validCheck.check();
		return this;
	}

}

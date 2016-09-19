package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ11_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ11_2 extends WizardPage {

	private CheckBox validCheck;

	public SQ11_2(WebDriver driver) {
		super(driver);
	}

	public SQ11_2 certification1(Properties data) {

		validCheck = new CheckBox(driver,
				"applicationData-formSpecific.statement.acknowledgement.optionList[1].value-1");
		validCheck.check();
		return this;
	}

}

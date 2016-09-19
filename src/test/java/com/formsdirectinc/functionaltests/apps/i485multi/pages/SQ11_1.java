package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ11_1 extends WizardPage {

	
	

	private MultiRadioOptions certification;

	public SQ11_1(WebDriver driver) {
		super(driver);

	}

	public void certification(String type) {

		certification = new MultiRadioOptions(driver, "applicationData-" + type
				+ "FormSpecific.statement.languageSkill");
		certification.selectOption(1);

	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ11_1 extends WizardPage {

	public SQ11_1(WebDriver driver) {
		super(driver);

	}

	public void Certification(Properties data) {
		
		MultiRadioOptions languageSkils=new MultiRadioOptions(driver, 
				"applicationData-formSpecific.statement.languageSkill");
		languageSkils.selectOption(1);
	}

}

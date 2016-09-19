package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public void setApplicationBasis(int option) {
		SelectElement basisOfApplication = new SelectElement(driver, "input[value='"+option+"']");
		basisOfApplication.selectElementUsingCSS();
	}

}

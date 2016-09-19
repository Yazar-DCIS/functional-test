package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {

	private YesNo currentlyInUS;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public void set_currentlyInUS() {
		currentlyInUS = new YesNo(driver, "applicant.currentlyInUS");
		currentlyInUS.yes();
	}

}

package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_1_1 extends WizardPage {

	private YesNo family_Status;

	public SQ4_1_1(WebDriver driver) {
		super(driver);
	}

	public void set_WithSpouseOrChildren() {
		family_Status = new YesNo(driver, "applicant.withSpouseOrChildren");
		family_Status.yes();
	}

}

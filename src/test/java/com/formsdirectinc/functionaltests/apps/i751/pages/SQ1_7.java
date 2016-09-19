package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_7 extends WizardPage {

	private YesNo children;

	public SQ1_7(WebDriver driver) {
		super(driver);

	}

	public void haveChildren() {
		children = new YesNo(driver, "applicant.haveChildren");
		children.no();

	}

}

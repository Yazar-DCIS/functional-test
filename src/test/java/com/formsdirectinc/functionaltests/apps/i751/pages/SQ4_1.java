package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_1 extends WizardPage {

	private YesNo accomadation;

	public SQ4_1(WebDriver driver) {
		super(driver);

	}

	public void setNoSQ4_1() {
		accomadation = new YesNo(driver, "formSpecific.requestAccomdation");
		accomadation.no();

	}

}

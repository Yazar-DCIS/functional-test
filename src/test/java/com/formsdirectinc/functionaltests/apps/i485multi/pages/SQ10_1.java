package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_1 extends WizardPage {

	private YesNo requestAccomodation;

	public SQ10_1(WebDriver driver) {
		super(driver);

	}

	public void requestAccomodation(String type) {

		requestAccomodation = new YesNo(driver, type
				+ "FormSpecific.disabilities.requestAccomdation");
		requestAccomodation.no();

	}

}

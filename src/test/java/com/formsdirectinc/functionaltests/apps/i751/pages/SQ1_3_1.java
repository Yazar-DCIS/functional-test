package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3_1 extends WizardPage {

	private YesNo residenceOutsideUS;

	public SQ1_3_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_3_1 residenceOutsideUS() {
		residenceOutsideUS = new YesNo(driver, "formSpecific.livingOutsideUS");
		residenceOutsideUS.no();
		return this;
	}

}

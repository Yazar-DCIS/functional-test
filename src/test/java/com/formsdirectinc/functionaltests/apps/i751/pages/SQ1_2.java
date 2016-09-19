package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {

	private YesNo haveUsedOtherNames;

	public SQ1_2(WebDriver driver) {
		super(driver);

	}

	public SQ1_2 hasNotUsedOtherNames() {
		haveUsedOtherNames = new YesNo(driver, "formSpecific.hasUsedOtherNames");
		haveUsedOtherNames.no();
		return this;
	}

}

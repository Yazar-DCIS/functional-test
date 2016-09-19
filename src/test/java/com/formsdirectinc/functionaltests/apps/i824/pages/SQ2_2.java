package com.formsdirectinc.functionaltests.apps.i824.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	private YesNo initialApplication;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public void basisForApplication() {

		initialApplication = new YesNo(driver,
				"eligibility.basisOfApplyingBusiness");
		initialApplication.no();

	}

}

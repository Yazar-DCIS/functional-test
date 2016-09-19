package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1 extends WizardPage {

	private YesNo GPR_holder;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public void set_PrimaryHolder() {
		GPR_holder = new YesNo(driver, "applicant.grantedtoPrimaryHolder");
		GPR_holder.no();
	}

}

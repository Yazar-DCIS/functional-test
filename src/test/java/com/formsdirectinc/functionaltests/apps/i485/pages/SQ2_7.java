package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_7 extends WizardPage {

	private YesNo haveEmployment;

	public SQ2_7(WebDriver driver) {
		super(driver);

	}

	public void noEmployment(Properties data) {
		haveEmployment = new YesNo(driver, "applicant.workedPastFiveYears");
		haveEmployment.no();
	}

}

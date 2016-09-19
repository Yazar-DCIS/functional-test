package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {

	private YesNo haveEmployment;

	public SQ4_2(WebDriver driver) {
		super(driver);

	}

	public void noHistory(Properties data) {
		haveEmployment = new YesNo(driver, "applicant.appliedPRStatus");
		haveEmployment.no();
	}

}

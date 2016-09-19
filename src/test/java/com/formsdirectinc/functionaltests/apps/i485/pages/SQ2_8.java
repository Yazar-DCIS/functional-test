package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_8 extends WizardPage {

	private YesNo employmentAbroad;

	public SQ2_8(WebDriver driver) {
		super(driver);

	}

	public void notOutside(Properties data) {
		employmentAbroad = new YesNo(driver, "applicant.workedOutsideUS");
		employmentAbroad.no();
	}

}

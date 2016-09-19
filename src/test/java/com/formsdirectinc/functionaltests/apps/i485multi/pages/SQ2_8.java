package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_8 extends WizardPage {

	private YesNo employmentStatusAbroad;

	public SQ2_8(WebDriver driver) {
		super(driver);

	}

	public void employmentStatusAbroad(String applicanttype) {

		employmentStatusAbroad = new YesNo(driver,applicanttype+"Applicant.hasWorkedOutsideUS");
		employmentStatusAbroad.no();

	}

}

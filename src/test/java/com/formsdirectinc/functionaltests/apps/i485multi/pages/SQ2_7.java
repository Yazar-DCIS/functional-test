package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_7 extends WizardPage {

	
	

	private YesNo employmentStatus;

	public SQ2_7(WebDriver driver) {
		super(driver);

	}

	public void employmentStatus(String applicanttype) {

		employmentStatus = new YesNo(driver,applicanttype+"Applicant.workedPastFiveYears");
		employmentStatus.no();

	}

}

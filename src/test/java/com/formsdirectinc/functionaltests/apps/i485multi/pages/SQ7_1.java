package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ7_1 extends WizardPage {

	
	

	private YesNo previousEmploymentAuthorization;

	public SQ7_1(WebDriver driver) {
		super(driver);

	}

	public void previousEmploymentAuthorization(String type) {

		if (type.equalsIgnoreCase("beneficiary")) {
			previousEmploymentAuthorization = new YesNo(driver,

			type + "FormSpecific.employmentAuthorization.applyForI765");

		} else {
			previousEmploymentAuthorization = new YesNo(driver,

			type + "FormSpecific.employmentAuthorization.hasAppliedEA");

		}
		previousEmploymentAuthorization.no();

	}

}

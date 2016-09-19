package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1_14 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_14 extends WizardPage {

	
	

	private YesNo beneficiaryImmigration;

	public SQ1_14(WebDriver driver) {
		super(driver);

	}

	public void beneficiaryOneYearSinceInspected() {

		beneficiaryImmigration = new YesNo(driver,
				"beneficiaryQuiz.oneYearSinceInspected");
		beneficiaryImmigration.yes();

	}

}

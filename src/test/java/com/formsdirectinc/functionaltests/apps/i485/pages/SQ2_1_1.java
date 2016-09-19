package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_1_1 extends WizardPage {

	private YesNo otherNames;

	public SQ2_1_1(WebDriver driver) {
		super(driver);

	}

	public void haveotherName(String answer) {
		otherNames = new YesNo(driver, "applicant.usedOtherNames");
		otherNames.setYesOrNo(answer);
		
	}

}
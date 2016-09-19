package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_4_1 extends WizardPage {

	private YesNo marriedBefore;

	public SQ2_4_1(WebDriver driver) {
		super(driver);

	}

	public void previousMarriedInformation(String answer) {

		marriedBefore = new YesNo(driver,
				"principalApplicant.hasMarriedEverBefore");

		marriedBefore.setYesOrNo(answer);

	}

}

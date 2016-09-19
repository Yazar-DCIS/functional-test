package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_1_1 extends WizardPage {

	
	private YesNo immigrationProcceding;

	public SQ1_1_1(WebDriver driver) {
		super(driver);

	}

	public void immigrationProcceding(String type,String answer) {

		if (type.equalsIgnoreCase("beneficiary")) {
			immigrationProcceding = new YesNo(driver,
					"beneficiaryQuiz.inImmigrationProceedings");
		}
		if (type.equalsIgnoreCase("principal")) {
			immigrationProcceding = new YesNo(driver,
					"principalQuiz.inImmigrationProceedings");
		}
		immigrationProcceding.setYesOrNo(answer);
	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_1 extends WizardPage {

	private YesNo exclusionDeportation;

	public SQ1_1_1(WebDriver driver) {
		super(driver);

	}

	public void haveimmigrationProceedings(String answer) {
		exclusionDeportation = new YesNo(driver,
				"applicant.currentImmigrationProceedings");
		exclusionDeportation.setYesOrNo(answer);
	}

	
}

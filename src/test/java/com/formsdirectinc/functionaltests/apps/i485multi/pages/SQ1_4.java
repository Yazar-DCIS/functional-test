package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ1_4 extends WizardPage {

	private YesNo inspectionInUS;

	public SQ1_4(WebDriver driver) {
		super(driver);

	}

	public void inspectionInUS() {

		inspectionInUS = new YesNo(driver, "principalQuiz.hasInspectedBy");
		inspectionInUS.yes();

	}

}

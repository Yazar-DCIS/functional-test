package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {

	private YesNo presenceInUS;

	public SQ1_2(WebDriver driver) {
		super(driver);

	}

	public void presenceInUS() {

		presenceInUS = new YesNo(driver, "principalQuiz.currentlyInUS");
		presenceInUS.yes();

	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_6 extends WizardPage {

	private YesNo inspectUs;

	public EQ1_6(WebDriver driver) {
		super(driver);

	}

	public EQ1_6 inspectedByUS(String answer) {
		
		inspectUs = new YesNo(driver, "principalQuiz.inspectedByUS");
		inspectUs.setYesOrNo(answer);
		saveScreenShot("i485", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_7 extends WizardPage {

	private YesNo lawfulStatus;

	public EQ1_7(WebDriver driver) {
		super(driver);

	}

	public EQ1_7 legallyInUS(String answer) {
		
		lawfulStatus = new YesNo(driver, "principalQuiz.inUSLegally");
		lawfulStatus.setYesOrNo(answer);
		saveScreenShot("i485", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_10 extends WizardPage {

	private YesNo spouseOrChildrenApply;
	public EQ1_10(WebDriver driver) {
		super(driver);

	}

	
	public EQ1_10 spouseOrChildrenApply(String answer) {
		
		
		spouseOrChildrenApply = new YesNo(driver, "principalQuiz.spouseOrChildrenApply");
		spouseOrChildrenApply.setYesOrNo(answer);
		saveScreenShot("i485multi", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

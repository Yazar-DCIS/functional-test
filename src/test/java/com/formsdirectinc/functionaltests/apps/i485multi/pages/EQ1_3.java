package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_3 extends WizardPage {

	private YesNo oneYearLastAdmitted;
	public EQ1_3(WebDriver driver) {
		super(driver);

	}

	
	public EQ1_3 oneYearLastAdmitted(String answer) {
		
		oneYearLastAdmitted = new YesNo(driver, "principalQuiz.oneYearLastAdmitted");
		oneYearLastAdmitted.setYesOrNo(answer);
		saveScreenShot("i485multi", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

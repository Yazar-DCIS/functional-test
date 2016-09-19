package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1 extends WizardPage {

	private YesNo livinginus;
	public EQ1_1(WebDriver driver) {
		super(driver);

	}

	
	public EQ1_1 livingUS(String answer) {
		
		livinginus = new YesNo(driver, "principalQuiz.livinginUS");
		livinginus.setYesOrNo(answer);
		saveScreenShot("i485", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

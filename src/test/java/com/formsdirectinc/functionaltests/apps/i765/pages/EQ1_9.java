package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_9 extends WizardPage {

	public YesNo haveVisa;

	public EQ1_9(WebDriver driver) {
		super(driver);
	}

	public EQ1_9 haveK3orK4Visa(String havK3orK4Visa) throws Exception {
		if (!havK3orK4Visa.equalsIgnoreCase("NA")) {
			
			haveVisa = new YesNo(driver, "quiz.haveKThreeVisa");
			haveVisa.setYesOrNo(havK3orK4Visa);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

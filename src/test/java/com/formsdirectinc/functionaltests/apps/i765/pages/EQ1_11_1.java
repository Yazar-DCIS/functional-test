package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_11_1 extends WizardPage {

	public YesNo haveJudgeOrder;

	public EQ1_11_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_11_1 HaveImmigrationJudgeOrder(String haveOrder)
			throws Exception {
		if (!haveOrder.equalsIgnoreCase("NA")) {
			
			haveJudgeOrder = new YesNo(driver, "quiz.haveJudgeOrder");
			haveJudgeOrder.setYesOrNo(haveOrder);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

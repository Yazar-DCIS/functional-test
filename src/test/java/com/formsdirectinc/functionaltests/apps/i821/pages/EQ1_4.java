package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_4 extends WizardPage {

	private YesNo status;

	public EQ1_4(WebDriver driver) {
		super(driver);
	}

	public EQ1_4 continuousResidence(String residence) {
		if (!residence.equalsIgnoreCase("NA")) {
			status = new YesNo(driver, "quiz.continuousResidence");
			status.setYesOrNo(residence);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_6_2 extends WizardPage {

	private YesNo familyRelative;

	public EQ1_6_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_6_2 immediateFamilyRelative(String answer) {
		
		familyRelative = new YesNo(driver, "principalQuiz.immediateFamilyRelative");
		familyRelative.setYesOrNo(answer);
		saveScreenShot("i485", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_13_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_13_1 extends WizardPage {

	public YesNo haveproof;

	public EQ1_13_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_13_1 HaveProofForI485Pending(String proofForI485Pending)
			throws Exception {
		if (!proofForI485Pending.equalsIgnoreCase("NA")) {
			
			haveproof = new YesNo(driver, "quiz.aosPendingProof");
			haveproof.setYesOrNo(proofForI485Pending);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

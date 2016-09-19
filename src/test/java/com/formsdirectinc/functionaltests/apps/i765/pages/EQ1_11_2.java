package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_11_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_11_2 extends WizardPage {

	public YesNo haveProof;

	public EQ1_11_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_11_2 haveProofForI881(String haveProofForI881Pending)
			throws Exception {
		if (!haveProofForI881Pending.equalsIgnoreCase("NA")) {
			
			haveProof = new YesNo(driver, "quiz.haveI881Proof");
			haveProof.setYesOrNo(haveProofForI881Pending);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

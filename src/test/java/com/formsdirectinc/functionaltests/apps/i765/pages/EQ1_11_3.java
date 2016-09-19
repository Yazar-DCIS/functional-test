package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_11_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_11_3 extends WizardPage {

	public YesNo haveDocument;

	public EQ1_11_3(WebDriver driver) {
		super(driver);
	}

	public EQ1_11_3 haveIdentityDocProof(String haveIdentityProof)
			throws Exception {
		if (!haveIdentityProof.equalsIgnoreCase("NA")) {
			
			haveDocument = new YesNo(driver, "quiz.haveIdentityDocProof");
			haveDocument.setYesOrNo(haveIdentityProof);
			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

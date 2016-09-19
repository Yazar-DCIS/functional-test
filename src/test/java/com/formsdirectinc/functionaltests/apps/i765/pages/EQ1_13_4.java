package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_13_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_13_4 extends WizardPage {

	public YesNo haveCopy;

	public EQ1_13_4(WebDriver driver) {
		super(driver);
	}

	public EQ1_13_4 CopyOfApprovalNotice(String haveApproval) throws Exception {
		if (!haveApproval.equalsIgnoreCase("NA")) {
			
			haveCopy = new YesNo(driver, "quiz.approvedRefugeeAsyleePetition");
			haveCopy.setYesOrNo(haveApproval);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

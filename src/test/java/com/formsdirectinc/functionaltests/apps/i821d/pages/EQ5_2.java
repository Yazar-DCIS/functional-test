package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ5_2 extends WizardPage {
	public YesNo receivedDACAEverLeftUS;
	public Sites site;

	public EQ5_2(WebDriver driver) {
		super(driver);
	}

	public EQ5_2 notLeftUSAfterReceivingDACA(String receivedDACAEverleftUS)
			throws Exception {

		if (!receivedDACAEverleftUS.equalsIgnoreCase("skip")) {
			receivedDACAEverLeftUS = new YesNo(driver,
					"quiz.receivedDACAEverLeftUS");
			receivedDACAEverLeftUS.setYesOrNo(receivedDACAEverleftUS);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

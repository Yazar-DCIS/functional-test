package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_3 extends WizardPage {

	public YesNo renewEADthruDACA;

	public EQ1_3(WebDriver driver) {
		super(driver);
	}

	public EQ1_3 renewEADthroughDACA(String renewingEADThroughDACA)
			throws Exception {
		if (!renewingEADThroughDACA.equalsIgnoreCase("NA")) {
			
			renewEADthruDACA = new YesNo(driver, "quiz.renewingEADthruDACA");
			renewEADthruDACA.setYesOrNo(renewingEADThroughDACA);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

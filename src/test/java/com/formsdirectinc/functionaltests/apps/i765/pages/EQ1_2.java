package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {

	public YesNo applyingEADthruDACA;

	public EQ1_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_2 applyingEADthroughDACA(String applyingEADThroughDACA)
			throws Exception {
		if (!applyingEADThroughDACA.equalsIgnoreCase("NA")) {
			
			applyingEADthruDACA = new YesNo(driver,	"quiz.applyingEADthruDACA");
			applyingEADthruDACA.setYesOrNo(applyingEADThroughDACA);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

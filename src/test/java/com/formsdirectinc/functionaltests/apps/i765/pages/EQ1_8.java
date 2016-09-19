package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_8 extends WizardPage {

	public YesNo haveK1Visa;

	public EQ1_8(WebDriver driver) {
		super(driver);
	}

	public EQ1_8 k1FianceVisa(String haveK1FianceVisa) throws Exception {
		if (!haveK1FianceVisa.equalsIgnoreCase("NA")) {
			
			haveK1Visa = new YesNo(driver, "quiz.haveFianceVisa");
			haveK1Visa.setYesOrNo(haveK1FianceVisa);

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

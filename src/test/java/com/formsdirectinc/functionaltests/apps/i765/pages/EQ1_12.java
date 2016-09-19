package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_12 extends WizardPage {

	public YesNo haveCard;

	public EQ1_12(WebDriver driver) {
		super(driver);
	}

	public EQ1_12 EverHadEADCard(String haveEADCard) throws Exception {
		if (!haveEADCard.equalsIgnoreCase("NA")) {
			
			haveCard = new YesNo(driver, "quiz.haveEADCard");
			haveCard.setYesOrNo(haveEADCard);
			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

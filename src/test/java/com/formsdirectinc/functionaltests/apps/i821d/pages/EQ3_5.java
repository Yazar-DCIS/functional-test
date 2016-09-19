package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_5 extends WizardPage {

	private YesNo dischargeFromUS;

	public EQ3_5(WebDriver driver) {
		super(driver);
	}

	public EQ3_5 dischargeFromUS(String dischargefromUS) throws Exception

	{
		if (!dischargefromUS.equalsIgnoreCase("skip")) {

			dischargeFromUS = new YesNo(driver, "quiz.honorableDischargeFromUS");
			dischargeFromUS.setYesOrNo(dischargefromUS);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

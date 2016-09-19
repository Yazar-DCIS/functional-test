package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_3 extends WizardPage {

	private YesNo dacaExpiredYearAgo;

	public EQ1_3(WebDriver driver) {
		super(driver);
	}

	public EQ1_3 dacaExpiredYearAgo(String dacaExpire) throws Exception

	{
		if (!dacaExpire.equalsIgnoreCase("skip")) {

			dacaExpiredYearAgo = new YesNo(driver, "quiz.dacaExpiredYearAgo");
			dacaExpiredYearAgo.setYesOrNo(dacaExpire);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

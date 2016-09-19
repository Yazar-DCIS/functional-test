package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	private YesNo i94_No;

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	public void set_Applicanti94No() {
		i94_No = new YesNo(driver, "applicant.havei94");
		i94_No.no();

	}

}

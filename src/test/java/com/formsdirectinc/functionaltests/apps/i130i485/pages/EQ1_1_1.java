package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1_1 extends WizardPage {

	private YesNo filledForm130;

	public EQ1_1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1_1 notFilledForm130() {

		filledForm130 = new YesNo(driver, "applicant.filedFormI130");
		filledForm130.no();
		return this;

	}

}

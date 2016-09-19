package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_10_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_10_2 extends WizardPage {
	private MultiRadioOptions code;

	public SQ1_10_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_10_2 i797ThreeDigitCode(String i797ReceiptCode) {
		if (!i797ReceiptCode.equalsIgnoreCase("NA")) {
			
			code = new MultiRadioOptions(driver,
					"applicationData-applicant.i797ReceiptNumber");
			if (i797ReceiptCode.equalsIgnoreCase("LIN")) {
				code.selectOption(1);
			}
			else if (i797ReceiptCode.equalsIgnoreCase("WAC")) {
				code.selectOption(2);
			}
			else if (i797ReceiptCode.equalsIgnoreCase("EAC")) {
				code.selectOption(3);
			}
			else if (i797ReceiptCode.equalsIgnoreCase("SRC")) {
				code.selectOption(4);
			}
			else if (i797ReceiptCode.equalsIgnoreCase("MSC")) {
				code.selectOption(5);
			}
			else if (i797ReceiptCode.equalsIgnoreCase("NoCode")) {
				code.selectOption(6);
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
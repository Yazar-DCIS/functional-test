package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {
	private YesNo incomeTax;
	private AdditionalInfoFields taxExplain;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 IncomeTax(Properties data, String filedIncomeTax) {
		if (!filedIncomeTax.equalsIgnoreCase("NA")) {
			
			incomeTax = new YesNo(driver, "applicant.filedIncomeTax.yesno");
			incomeTax.setYesOrNo(filedIncomeTax);
			if (filedIncomeTax.equalsIgnoreCase("Yes")) {
				
				taxExplain = new AdditionalInfoFields(driver,

				"applicationData-applicant.filedIncomeTax.explain");
				taxExplain.normalText(data.getProperty("Income"));
			}
			
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

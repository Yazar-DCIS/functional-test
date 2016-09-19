package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_5 extends WizardPage {

	private MultiRadioOptions reasonForApplication;
	private YesNo uscis;

	public SQ3_5(WebDriver driver) {
		super(driver);

	}

	public SQ3_5 reasonForApplication(String reason, String uscisError)
			throws Exception {
		if (!reason.equalsIgnoreCase("NA")) {
			reasonForApplication = new MultiRadioOptions(driver,

			"applicationData-formSpecific.applyingFor");

			if (reason.equalsIgnoreCase("AcceptEmployment")) {
				reasonForApplication.selectOption(1);
			}
			else if (reason.equalsIgnoreCase("ReplaceLostEAD")) {
				reasonForApplication.selectOption(2);
			}
			else if (reason.equalsIgnoreCase("ReplaceIncorrectEAD")) {
				reasonForApplication.selectOption(3);
				uscis = new YesNo(driver,"formSpecific.incorrectEmploymentAuthorizationDocument");
				uscis.setYesOrNo(uscisError);
			}
			else if (reason.equalsIgnoreCase("RenewEmployment")) {
				reasonForApplication.selectOption(4);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

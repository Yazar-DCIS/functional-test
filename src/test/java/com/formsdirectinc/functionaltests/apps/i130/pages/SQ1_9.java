package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_9 extends WizardPage {

	private YesNo lpr_Status;

	public SQ1_9(WebDriver driver) {
		super(driver);

	}

	public SQ1_9 applicantGreenCardStatus(String permanentResident) {

		if (permanentResident.equalsIgnoreCase("yes")||permanentResident.equalsIgnoreCase("no")) {
			lpr_Status = new YesNo(driver, "applicant.lawfulPermanentResident");
			lpr_Status.setYesOrNo(permanentResident);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {

	public SQ2_6(WebDriver driver) {
		super(driver);
	}

	
	private MaritalInfo setMartial;

	public SQ2_6 marital_Status(String maritalstatus) {

		if (!maritalstatus.equalsIgnoreCase("NA")) {

			setMartial = new MaritalInfo(driver,
					"applicationData-applicant.maritalStatus");
			setMartial.setMarriageStatus(maritalstatus);

			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

}

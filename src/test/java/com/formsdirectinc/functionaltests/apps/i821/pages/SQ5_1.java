package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1 extends WizardPage {

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	
	private YesNo ead;

	public SQ5_1 setEAD(String employmentdetails) {
		if (!employmentdetails.equalsIgnoreCase("NA")) {

			ead = new YesNo(driver,
					"employmentDetails.appliedEmploymentAuthorization");
			ead.setYesOrNo(employmentdetails);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

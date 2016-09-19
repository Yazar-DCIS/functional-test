package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90:Applicant's Certification
 * @author Orina
 */

public class SQ5_2 extends WizardPage {

	
	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_2 applicantCertification() {

		CheckBox applicantCertification = new CheckBox(driver,	"applicationData-applicant.applicantCertification");
		applicantCertification.check();
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

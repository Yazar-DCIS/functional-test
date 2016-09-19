package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90:Acknowledgement of Appointment
 * @author Orina
 */

public class SQ5_1 extends WizardPage {

	
	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 acknowledgements() {

		CheckBox agreeToAcknowledgements = new CheckBox(driver,	"applicationData-applicant.acknowledgements");
		agreeToAcknowledgements.check();
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

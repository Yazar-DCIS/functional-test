package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_4 extends WizardPage {

	private MultiRadioOptions i485Status;

	public SQ3_4(WebDriver driver) {
		super(driver);
	}

	public SQ3_4 reasonForApplication(String i485FilingProcess)
			throws Exception {
		if (!i485FilingProcess.equalsIgnoreCase("NA")) {
			i485Status = new MultiRadioOptions(driver,
					"applicationData-formSpecific.processOfFiling");
			if (i485FilingProcess.equalsIgnoreCase("i485")) {
				i485Status.selectOption(1);
			}
			else if (i485FilingProcess.equalsIgnoreCase("i485ContinousResidence")) {
				i485Status.selectOption(2);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
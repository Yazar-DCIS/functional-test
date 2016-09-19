package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_3_1 extends WizardPage {

	private MultiRadioOptions fileI485;

	public SQ3_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_3_1 reasonForApplication(String filedI485On,
			String basisOnFilingI485) throws Exception {

		if (!filedI485On.equalsIgnoreCase("NA")) {
			fileI485 = new MultiRadioOptions(driver,
					"applicationData-formSpecific.filedFormPeriod");

			if (filedI485On.equalsIgnoreCase("BeforeJuly30,2007")) {
				fileI485.selectOption(1);
			}
			else if (filedI485On.equalsIgnoreCase("OnOrAfterJuly30,2007")) {
				fileI485.selectOption(2);
			}

		}

		

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_3 extends WizardPage {

	private MultiRadioOptions reasonForApplication;
	private YesNo I485Status;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 reasonForApplication(String filedI485, String locationFiledI485)
			throws Exception {
		if (!filedI485.equalsIgnoreCase("NA")) {

			I485Status = new YesNo(driver, "formSpecific.appliedForm485");
			if (filedI485.equalsIgnoreCase("No")) {
				I485Status.no();

				reasonForApplication = new MultiRadioOptions(driver,

				"applicationData-formSpecific.applicationFiledLocation");

				if (locationFiledI485.equalsIgnoreCase("USCISChicagoLockBox")) {
					reasonForApplication.selectOption(1);
				}
				else if (locationFiledI485.equalsIgnoreCase("immigrationJudge")) {
					reasonForApplication.selectOption(2);
				}
				else if (locationFiledI485.equalsIgnoreCase("i485Pending")) {
					reasonForApplication.selectOption(3);
				}
			}
			else if (filedI485.equalsIgnoreCase("Yes")) {
				I485Status.yes();
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

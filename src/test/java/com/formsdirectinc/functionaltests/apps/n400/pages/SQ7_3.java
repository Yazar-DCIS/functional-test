package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ7_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ7_3 extends WizardPage {

	private YesNo service;
	private AdditionalInfoFields reasons;
	private DateTag registeredDate;

	public SQ7_3(WebDriver driver) {
		super(driver);

	}

	public SQ7_3 selectiveServiceRegistration(Properties copies,
			Properties data, String answer) {

		if (!answer.equalsIgnoreCase("NA")) {

			service = new YesNo(driver,
					"formSpecific.ssn.livedUSBetween18And26");
			if (answer.equalsIgnoreCase("No")) {
				service.no();
			}
			if (answer.equalsIgnoreCase("Yes")) {
				service.yes();

				service = new YesNo(driver, "formSpecific.ssn.haveRegistered");
				if (answer.equalsIgnoreCase("No")) {
					service.no();

				}
				if (answer.equalsIgnoreCase("Yes")) {
					service.yes();

					registeredDate = new DateTag(driver,
							"formSpecific.ssn.dateRegistered");
					registeredDate.selectDate(data.getProperty("DOE"));
					reasons = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.ssn.SSN");
					reasons.normalText(data.getProperty("ARN"));
				}
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ7_3");
			 clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_1 extends WizardPage {

	private MultiRadioOptions interpreterInfo;
	private AdditionalInfoFields interpreterLanguage;
	private Name_FirstMiddleLast interpreterName;
	private PhoneNumber interpreterNumber;

	public SQ10_1(WebDriver driver) {
		super(driver);

	}

	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public SQ10_1 interpreterInfo(Properties copies, Properties data,
			String interpreterHelp, String skipCertification)
			throws InterruptedException {

		if (!interpreterHelp.equalsIgnoreCase("NA")) {

			interpreterInfo = new MultiRadioOptions(driver,
					"applicationData-applicant.certification.readAndUnderstandEnglish");
			if (interpreterHelp.equalsIgnoreCase("No")) {
				interpreterInfo.selectOption(2);

				interpreterLanguage = new AdditionalInfoFields(driver,

				"applicationData-applicant.certification.languageOfinterpreter");
				interpreterLanguage.normalText(data
						.getProperty("interpreterLanguage"));

				interpreterName = new Name_FirstMiddleLast(driver,
						"applicationData",

						"applicant.certification.nameOfinterpreter");
				interpreterName
						.setFirstNameField(data.getProperty("FirstName"));
				interpreterName.setLastNameField(data.getProperty("LastName"));

				interpreterNumber = new PhoneNumber(driver,
						"applicationData-applicant.certification.phoneOfInterpreter");
				interpreterNumber.setPhoneCode(data.getProperty("Phone1"));
				interpreterNumber.setPhoneNumber(data.getProperty("Phone2"));

			}
			else if (interpreterHelp.equalsIgnoreCase("Yes")) {
				interpreterInfo.selectOption(1);
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ10_1");
			 clickContinueInSQ();

		}

		return this;
	}

}

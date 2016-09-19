package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_7_1 extends WizardPage {

	private AdditionalInfoFields mail;
	private CommonInputClasses phone_No;

	public SQ2_7_1(WebDriver driver) {
		super(driver);
	}

	public void set_MailAddress(Properties data) {

		mail = new AdditionalInfoFields(driver,
				"applicationData-applicant.mailAddress");
		mail.normalText(data.getProperty("Mail"));
	}

	public void set_CellPhoneNumber(Properties data) {
		phone_No = new CommonInputClasses(driver);
		phone_No.applicantNumberDetails(
				"applicationData-applicant.cellPhoneNumber", data);

	}

}

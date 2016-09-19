package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	private CommonInputClasses applicantName;

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public void set_ApplicantName(Properties data) {
		applicantName = new CommonInputClasses(driver);
		applicantName.applicantNameDetails("applicant.name", data);
	}

}

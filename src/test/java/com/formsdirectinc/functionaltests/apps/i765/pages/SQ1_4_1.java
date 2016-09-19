package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4_1 extends WizardPage {

	private MaritalInfo marital;

	public SQ1_4_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_4_1 maritalStatus(Properties data, String maritalStatus)
			throws Exception {
		
		marital = new MaritalInfo(driver, "applicant.maritalStatus");

		if (maritalStatus.equalsIgnoreCase("Single")) {
			marital.setMarriageStatusByName(data.getProperty("status_Single"));
		}
		else if (maritalStatus.equalsIgnoreCase("Married")) {
			marital.setMarriageStatusByName(data.getProperty("status_Married"));
		}
		else if (maritalStatus.equalsIgnoreCase("Widowed")) {
			marital.setMarriageStatusByName(data.getProperty("status_Widowed"));
		}
		else if (maritalStatus.equalsIgnoreCase("Divorced")) {
			marital.setMarriageStatusByName(data.getProperty("status_Divorced"));
		}

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

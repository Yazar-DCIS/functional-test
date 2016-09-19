package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_2 extends WizardPage {

	private YesNo applicant_status;
	private AdditionalInfoFields applicant_Explain;

	public SQ6_2(WebDriver driver) {
		super(driver);
	}

	public void setEmploymentDetails(Properties data) {
		applicant_status = new YesNo(driver, "applicant.haveEmployed");
		applicant_status.no();
		applicant_Explain = new AdditionalInfoFields(driver,
				"applicationData-applicant.sourceOfIncome");
		applicant_Explain.normalText(data.getProperty("Income"));

	}

}

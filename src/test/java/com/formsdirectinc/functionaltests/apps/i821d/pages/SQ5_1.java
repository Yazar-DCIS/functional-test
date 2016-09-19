package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1 extends WizardPage {
	private TaxDetails applicantEmploymentDetails;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 applicantEmploymentDetails(Properties data) throws Exception {

		applicantEmploymentDetails = new TaxDetails(driver,"applicationData-applicant.employmentDetails");
		applicantEmploymentDetails.setCurrentAnnualIncome(data.getProperty("taxIncome1"));
		applicantEmploymentDetails.setCurrentAnnualExpenses(data.getProperty("taxIncome1"));
		applicantEmploymentDetails.setCurrentValueAssests(data.getProperty("taxIncome1"));
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_9 extends WizardPage {

	private AdditionalInfoFields income;

	public SQ2_9(WebDriver driver) {
		super(driver);

	}

	public void incomeInformation(Properties data) {

		income = new AdditionalInfoFields(driver,
				"applicationData-principalApplicant.annualIncome");
		income.isStatusOther(data.getProperty("taxIncome1"));
		income = new AdditionalInfoFields(driver,
				"applicationData-principalApplicant.savingsInUSBanks");
		income.isStatusOther(data.getProperty("taxIncome1"));
		income = new AdditionalInfoFields(driver,
				"applicationData-principalApplicant.personalPropertyValue");
		income.isStatusOther(data.getProperty("taxIncome1"));
		income = new AdditionalInfoFields(driver,
				"applicationData-principalApplicant.marketValue");
		income.isStatusOther(data.getProperty("taxIncome1"));

	}

}

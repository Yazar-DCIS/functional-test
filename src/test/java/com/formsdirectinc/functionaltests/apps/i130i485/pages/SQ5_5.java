package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_5 extends WizardPage {

	private YesNo income,sameSource;

	public SQ5_5(WebDriver driver) {
		super(driver);
	}

	public SQ5_5 contributions(String haveIncome,String provideIncomeFromSameSource) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(haveIncome.equalsIgnoreCase("yes")||haveIncome.equalsIgnoreCase("no"))
		{
		
		income = new YesNo(driver,
				"applicant.sponsorInfo.relativeFinancialContribution.haveIncome");
		
		if(haveIncome.equalsIgnoreCase("yes"))
		{
			income.yes();
			sameSource = new YesNo(driver,
					"applicant.sponsorInfo.relativeFinancialContribution.sameSource");
			if(provideIncomeFromSameSource.equalsIgnoreCase("yes"))
			{
				sameSource.yes();
				
				TaxDetails annualIncome=new TaxDetails(driver, "applicationData-applicant.sponsorInfo.relativeFinancialContribution");
				annualIncome.setCurrentAnnualIncome(i130i485.getProperty("applicant.sponsorInfo.relativeFinancialContribution.currentAnnualIncome"));
				
			}
			else if(provideIncomeFromSameSource.equalsIgnoreCase("no"))
			{
				sameSource.no();
			}
		}
		else if(haveIncome.equalsIgnoreCase("no"))
		{
			income.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		

		return this;
	}

}

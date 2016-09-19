package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ4_11_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_11_2 extends WizardPage {

	private YesNo requiredFederalIncome,filedfederalIncome;
	private MultiRadioOptions submitITReturns;;
	
	public SQ4_11_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_11_2 incomeDetails(String wereYouRequiredFederalIncome,String haveYouFiledfederalIncome,
			String taxSubmission) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		requiredFederalIncome = new YesNo(driver,
				"applicant.incomeInfo.requiredFileFederalIncome");
		TaxDetails taxInfo = new TaxDetails(driver, "applicationData-applicant.incomeInfo");
		
		if(wereYouRequiredFederalIncome.equalsIgnoreCase("Yes"))
		{
			requiredFederalIncome.yes();
			
			filedfederalIncome = new YesNo(driver,"applicant.incomeInfo.filedFederalincome");
			filedfederalIncome.setYesOrNo(haveYouFiledfederalIncome);
						
			taxInfo.setTaxYear(i130i485.getProperty("applicant.incomeInfo.taxYear"));
			taxInfo.setTotalIncome(i130i485.getProperty("applicant.incomeInfo.totalIncome"));
			taxInfo.setSecondYearTax(i130i485.getProperty("applicant.incomeInfo.secondYearTax"));
			taxInfo.setSecondYearIncome(i130i485.getProperty("applicant.incomeInfo.secondYearIncome"));
			taxInfo.setThirdYearTax(i130i485.getProperty("applicant.incomeInfo.thirdYearTax"));
			taxInfo.setThirdYearIncome(i130i485.getProperty("applicant.incomeInfo.thirdYearIncome"));
			
			submitITReturns = new MultiRadioOptions(driver,	"applicant.incomeInfo.filedFederalincome");
			
			if(taxSubmission.equalsIgnoreCase("recentTaxes")){
				submitITReturns.selectOption(1);
			}
			else if(taxSubmission.equalsIgnoreCase("fromLast3years")){
				submitITReturns.selectOption(2);
			}
			
		}
		else if(wereYouRequiredFederalIncome.equalsIgnoreCase("No"))
		{
			requiredFederalIncome.no();
			taxInfo.setFederalIncome(i130i485.getProperty("applicant.incomeInfo.fileFederalIncomeNotRequired"));
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

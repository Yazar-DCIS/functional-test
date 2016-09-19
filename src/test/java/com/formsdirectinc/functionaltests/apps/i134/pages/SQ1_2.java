package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2 extends WizardPage {
	private YesNo currentlyInUs;
	private MultiRadioOptions selectImmigrationStatus;
	private DateTag dateLivedInUs;
	private Numbers arnNo,i94No;
	
	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 currentlyInUS(Properties data,String answer,int immigrationStatus) {
		currentlyInUs = new YesNo(driver, "eligibility.currentlyInUS");
		currentlyInUs.setYesOrNo(answer);
		if(answer.equalsIgnoreCase("yes"))
		{
			selectImmigrationStatus = new MultiRadioOptions(driver,"applicationData-eligibility.immigrationStatus");
			selectImmigrationStatus.selectOption(immigrationStatus);
			if(immigrationStatus==2)
			{
				arnNo = new Numbers(driver, "applicationData-applicant.ARN.arn");
				arnNo.setAlienRegistrationNumber(data.getProperty("ARN"));
			}
			else if(immigrationStatus==3)
			{
				
				i94No = new Numbers(driver, "eligibility.AOSApplicantI94");
				i94No.setArrivalRecordNumber(data.getProperty("i94_1"), data.getProperty("i94_2"));
				
			}
			else if(immigrationStatus==4)
			{
				i94No = new Numbers(driver, "eligibility.visaHolderI94");
				i94No.setArrivalRecordNumber(data.getProperty("i94_1"), data.getProperty("i94_2"));
				
			}
		}
		
		return this;
	}

	// Lived in US Since
	public SQ1_2 dateLivedinUsSince(Properties data) {
		dateLivedInUs = new DateTag(driver, "eligibility.livedInUS");
		dateLivedInUs.selectDay(data.getProperty("I134_LivedInUs_Day"));
		dateLivedInUs.selectMonth(data.getProperty("I134_LivedInUs_Month"));
		dateLivedInUs.selectYear(data.getProperty("I134_LivedInUs_Year"));
		return this;
	}

}

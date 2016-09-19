package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Alien Registration Number
 * @author Orina
 */

public class SQ1_2_1 extends WizardPage {

	public SQ1_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_2_1 alienRegistrationNumber(Properties data, String haveARN,String unknownReason) {

		Numbers number = new Numbers(driver,"applicationData-applicant.ARN");
		if(haveARN.equalsIgnoreCase("yes"))
		{
			number.setAlienRegistrationNumber(data.getProperty("applicant.ARN.arn"));
		}
		else if(haveARN.equalsIgnoreCase("no"))
		{
			number.setNumberUnknown();
			
			MultiRadioOptions reasonForUnknown=new MultiRadioOptions(driver, "applicationData-applicant.whyUnableToGetARN");
			
			if(unknownReason.equalsIgnoreCase("cardLost"))
			{
				reasonForUnknown.selectOption(1);
			}
			else if(unknownReason.equalsIgnoreCase("cardDamaged"))
			{
				reasonForUnknown.selectOption(2);
			}
			else if(unknownReason.equalsIgnoreCase("cardNeverReceived"))
			{
				reasonForUnknown.selectOption(3);
			}
		}
		
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

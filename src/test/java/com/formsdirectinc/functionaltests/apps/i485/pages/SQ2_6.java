package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_6 extends WizardPage {

	private Numbers number;
	private YesNo haveARN;

	public SQ2_6(WebDriver driver) {
		super(driver);

	}

	public void haveARN(Properties data,String answer) {
		haveARN = new YesNo(driver, "applicant.hasARNNumber");
		haveARN.setYesOrNo(answer);
		if(answer.equalsIgnoreCase("yes"))
		{
			arnNumber(data);
		}
		
	}

	
	public void arnNumber(Properties data) {
		number = new Numbers(driver, "applicationData-applicant.ARN");
		number.setAlienRegistrationNumber(data.getProperty("ARN"));
	}

}

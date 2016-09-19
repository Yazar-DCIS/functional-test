package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2 extends WizardPage {

	private Numbers number;
	private YesNo haveARN;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 haveARN(String arn, Properties data) {
		if (!arn.equalsIgnoreCase("NA")) {
			haveARN = new YesNo(driver, "applicant.haveARN");
			haveARN.setYesOrNo(arn);
			if (arn.equalsIgnoreCase("Yes")) {
				
				number = new Numbers(driver, "applicationData-applicant.ARN");
				number.setAlienRegistrationNumber(data.getProperty("ARN"));
			} 
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

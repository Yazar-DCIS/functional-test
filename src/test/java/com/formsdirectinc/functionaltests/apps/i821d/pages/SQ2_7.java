package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {

	private YesNo haveARN;
	private Numbers arnnumber;

	public SQ2_7(WebDriver driver) {
		super(driver);

	}

	public SQ2_7 applicantARN(String hasARN, Properties data) throws Exception {
		if (!hasARN.equalsIgnoreCase("Skip")) {
			haveARN = new YesNo(driver, "applicant.havingARN");
			haveARN.setYesOrNo(hasARN);
			if (hasARN.equalsIgnoreCase("Yes")) {
				arnnumber = new Numbers(driver, "applicationData-applicant.ARN");
				arnnumber.setAlienRegistrationNumber(data.getProperty("ARN"));
			} 

		}
		return this;
	}

}

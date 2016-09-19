package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_4 extends WizardPage {

	private YesNo haveSocialNumber;
	private Numbers socialNumber;

	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_4 ssnInfo(String haveSSN, Properties data) {

		if (!haveSSN.equalsIgnoreCase("NA")) {

			haveSocialNumber = new YesNo(driver, "applicant.haveTheSSNum");
			haveSocialNumber.setYesOrNo(haveSSN);
			if (haveSSN.equalsIgnoreCase("Yes")) {
				
				socialNumber = new Numbers(driver,
						"applicationData-applicant.SSN");
				socialNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
						data.getProperty("SSN_2"), data.getProperty("SSN_3"));

			}

			
			saveScreenShot("n600", "SQ1_4"); clickContinueInSQ();
		}
		return this;
	}

}

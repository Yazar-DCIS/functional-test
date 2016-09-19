package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5 extends WizardPage {

	private Numbers ssn_Number;
	private YesNo ssnNumber;

	public SQ1_5(WebDriver driver) {
		super(driver);
	}

	public SQ1_5 SSNDetails(Properties data, String havSSN, double SSNCount)
			throws Exception {
		if (!havSSN.equalsIgnoreCase("NA")) {
			
			ssnNumber = new YesNo(driver, "formSpecific.haveSSN");
			ssnNumber.setYesOrNo(havSSN);
			
			if (havSSN.equalsIgnoreCase("Yes")) {
				
				for (int i = 0; i < SSNCount; i++) {
					ssn_Number = new Numbers(driver,
							"applicationData-applicant.socialSecurityNumber[" + i + "].ssNum");
					ssn_Number.setSocialSecurityNumber(
							data.getProperty("SSN_1"),
							data.getProperty("SSN_2"),
							data.getProperty("SSN_3"));

					if (i < SSNCount - 1) {
						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnother();
					}
				}
			}
		

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

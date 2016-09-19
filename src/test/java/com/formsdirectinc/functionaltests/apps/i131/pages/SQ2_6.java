package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {
	private YesNo ssNumber;
	private CommonInputClasses ssn;

	public SQ2_6(WebDriver driver) {
		super(driver);
	}

	public SQ2_6 SSN(Properties data, String havSSN) {

		
		ssNumber = new YesNo(driver, "applicant.haveSSN");
		ssNumber.setYesOrNo(havSSN);
		
		if (havSSN.equalsIgnoreCase("Yes")) {
			ssn = new CommonInputClasses(driver);
			ssn.applicantSSNDetails("applicationData-applicant.SSN", data);
		}
		
		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}
}

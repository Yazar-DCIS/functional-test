package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_8 extends WizardPage {

	public SQ2_8(WebDriver driver) {
		super(driver);
	}

	
	private YesNo havingSSN;
	private AddAnotherField ssnNumber;

	public SQ2_8 set_SSN(String ssnnumber, Properties data) {

		if (!ssnnumber.equalsIgnoreCase("NA")) {

			havingSSN = new YesNo(driver, "applicant.havingSSN");
			havingSSN.setYesOrNo(ssnnumber);
			if (ssnnumber.equalsIgnoreCase("Yes")) {
				
				ssnNumber = new AddAnotherField(driver);
				ssnNumber.addAnotherSSN(2, data, "applicationData-applicant");

			} 
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

}

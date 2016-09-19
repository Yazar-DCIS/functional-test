package com.formsdirectinc.functionaltests.apps.i821d.pages;

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

	private YesNo haveSSN;
	private AddAnotherField addssnnumber;

	public SQ2_8(WebDriver driver) {
		super(driver);
	}

	public SQ2_8 applicantSSN(String ssn, int count, Properties data)
			throws Exception {
		if (!ssn.equalsIgnoreCase("Skip")) {
			haveSSN = new YesNo(driver, "applicant.havingSSN");
			haveSSN.setYesOrNo(ssn);
			if (ssn.equalsIgnoreCase("Yes")) {
				
				addssnnumber = new AddAnotherField(driver);
				addssnnumber.addAnotherSSN(count, data,
						"applicationData-applicant");

			} 

		}
		return this;
	}

}

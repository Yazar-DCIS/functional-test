package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2 extends WizardPage {
	private YesNo previousEmployment;
	private AddAnotherField addAontherEAD;

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_2 applicantPreviousEmployment(String previouslyEmployed,
			int count, Properties data) throws Exception {
		if (!previouslyEmployed.equalsIgnoreCase("Skip")) {
			previousEmployment = new YesNo(driver,
					"applicant.employmentDetails.previouslyAppliedEmploymentAuthorization");
			previousEmployment.setYesOrNo(previouslyEmployed);
			if (previouslyEmployed.equalsIgnoreCase("Yes")) {
				addAontherEAD = new AddAnotherField(driver);
				addAontherEAD.addAnotherEAD(count, data,
						"applicant.employmentDetails");

			}

			

		}
		return this;
	}
}

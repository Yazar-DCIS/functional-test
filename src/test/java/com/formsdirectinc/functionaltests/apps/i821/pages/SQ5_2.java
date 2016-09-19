package com.formsdirectinc.functionaltests.apps.i821.pages;

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

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	
	private YesNo employmentDetails;
	private AddAnotherField workAuthorization;

	public SQ5_2 setPreviousEAD(String previousEAD, Properties data,int eadCount) {
		if (!previousEAD.equalsIgnoreCase("NA")) {

			employmentDetails = new YesNo(driver,
					"employmentDetails.previouslyAppliedEmploymentAuthorization");
			employmentDetails.setYesOrNo(previousEAD);
			if (previousEAD.equalsIgnoreCase("Yes")) {
				workAuthorization = new AddAnotherField(driver);
				workAuthorization.addAnotherEAD(eadCount, data, "employmentDetails");

			}
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

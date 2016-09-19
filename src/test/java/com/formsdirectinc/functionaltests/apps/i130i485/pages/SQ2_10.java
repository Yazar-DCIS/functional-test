package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_10 extends WizardPage {

	private YesNo inspection;
	private MultiRadioOptions legalStatus;

	public SQ2_10(WebDriver driver) {
		super(driver);
	}

	public SQ2_10 inspections(String inspectedByOfficer,String currentlyLawfulStatus) {
		
		inspection = new YesNo(driver, "applicant.inspectedByOfficer");
		inspection.setYesOrNo(inspectedByOfficer);
		if(inspectedByOfficer.equalsIgnoreCase("Yes"))
		{
			legalStatus = new MultiRadioOptions(driver,
					"applicationData-applicant.currentlyLawfulStatus");
			if(currentlyLawfulStatus.equalsIgnoreCase("Yes"))
			{
				legalStatus.selectOption(1);
			}
			else if(currentlyLawfulStatus.equalsIgnoreCase("No"))
			{
				legalStatus.selectOption(2);
			}
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

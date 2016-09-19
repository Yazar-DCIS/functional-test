package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2 extends WizardPage {
	private YesNo travel;
	private AdditionalInfoFields travelExplanation;

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_2 travelDetails(Properties data, String planToTravel) {
		if (!planToTravel.equalsIgnoreCase("NA")) {
			travel = new YesNo(driver, "applicant.planToTravel.yesno");
			travel.setYesOrNo(planToTravel);
			if (planToTravel.equalsIgnoreCase("Yes")) {
				
				travelExplanation = new AdditionalInfoFields(driver,
				"applicationData-applicant.planToTravel.explain");
				travelExplanation.normalText(data.getProperty("I131_Purpose"));
			}
			
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}
}
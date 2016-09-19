package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ11_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ11_2 extends WizardPage {

	private MultiRadioOptions sponsorIs;

	public SQ11_2(WebDriver driver) {
		super(driver);
	}

	public SQ11_2 relativeAdditionalSponsorInformation(String additionalSponsorType) {

		if(additionalSponsorType.equalsIgnoreCase("jointSponsor")
				||additionalSponsorType.equalsIgnoreCase("householdMember")
				||additionalSponsorType.equalsIgnoreCase("jointAndHouseHold"))
		{
		sponsorIs = new MultiRadioOptions(driver,
				"applicationData-applicant.signedAOS");
		if(additionalSponsorType.equalsIgnoreCase("jointSponsor"))
		{
			sponsorIs.selectOption(1);
		}
		else if(additionalSponsorType.equalsIgnoreCase("householdMember"))
		{
			sponsorIs.selectOption(2);
		}
		else if(additionalSponsorType.equalsIgnoreCase("jointAndHouseHold"))
		{
			sponsorIs.selectOption(3);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		

		return this;
	}

}

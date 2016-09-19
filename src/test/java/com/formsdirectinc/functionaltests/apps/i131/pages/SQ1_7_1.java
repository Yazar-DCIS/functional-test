package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_7_1 extends WizardPage {
	private AdditionalInfoFields tripDays;
	private MultiRadioOptions numberOfTrips;

	public SQ1_7_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_7_1 lengthOfTrip(String reason, String tripCount) {
		if (!tripCount.equalsIgnoreCase("NA")) {
			
			tripDays = new AdditionalInfoFields(driver,
					"applicationData-applicant.lengthOfTrip");
			tripDays.normalText("45");

			if ((reason.equalsIgnoreCase("PendingI485"))
					|| (reason.equalsIgnoreCase("ApprovedI821"))
					|| (reason.equalsIgnoreCase("PendingI821"))
					|| (reason.equalsIgnoreCase("ApprovedI821D"))) {
				numberOfTrips = new MultiRadioOptions(driver,

				"applicationData-applicant.countOfTrip");

				if (tripCount.equalsIgnoreCase("One")) {
					numberOfTrips.selectOption(1);
				} else if (tripCount.equalsIgnoreCase("Many")) {
					numberOfTrips.selectOption(2);
				}
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}

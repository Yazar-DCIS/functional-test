package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {
	private MultiRadioOptions timespentOutsideUs;
	private YesNo trips;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 timeOutSideUs(String timeSpentOutsideUS) {
		if (!timeSpentOutsideUS.equalsIgnoreCase("NA")) {
			// new control
			trips = new YesNo(driver,
					"applicant.everLeftUsSincePermanentResident");
			trips.yes();

			
			timespentOutsideUs = new MultiRadioOptions(driver,

			"applicationData-applicant.timeSpentOutsideUS");

			if (timeSpentOutsideUS.equalsIgnoreCase("lessThan3months")) {
				timespentOutsideUs.selectOption(1);
			}
			else if (timeSpentOutsideUS.equalsIgnoreCase("6monthTo1year")) {
				timespentOutsideUs.selectOption(2);
			}
			else if (timeSpentOutsideUS.equalsIgnoreCase("1to2year")) {
				timespentOutsideUs.selectOption(3);
			}
			else if (timeSpentOutsideUS.equalsIgnoreCase("2to3year")) {
				timespentOutsideUs.selectOption(4);
			}
			else if (timeSpentOutsideUS.equalsIgnoreCase("3to4year")) {
				timespentOutsideUs.selectOption(5);
			}
			else if (timeSpentOutsideUS.equalsIgnoreCase("moreThan4year")) {
				timespentOutsideUs.selectOption(6);
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
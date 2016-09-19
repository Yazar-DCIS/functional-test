
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_6 extends WizardPage {

	protected YesNo servedArmy;
	protected DateTag servedFrom, servedTo;
	protected MultiRadioOptions dischargeType;

	public SQ5_6(WebDriver driver) {
		super(driver);

	}

	public SQ5_6 militaryServices(Properties data, String servedMilitary,
			String dischargedAs) {

		if (!servedMilitary.equalsIgnoreCase("NA")
				&& !dischargedAs.equalsIgnoreCase("NA")) {

			servedArmy = new YesNo(driver,
					"applicant.fatherInfo.militaryService.hasServedArmedForces");

			if (servedMilitary.equalsIgnoreCase("Yes")) {
				servedArmy.yes();

				servedFrom = new DateTag(driver,
						"applicant.fatherInfo.militaryService.dateOfService.fromDate");
				servedFrom.selectDate(data.getProperty("fromDate"));
				servedTo = new DateTag(driver,
						"applicant.fatherInfo.militaryService.dateOfService.toDate");
				servedTo.selectDate(data.getProperty("toDate"));

				dischargeType = new MultiRadioOptions(driver,

				"applicationData-applicant.fatherInfo.militaryService.service");

				if (dischargedAs.equalsIgnoreCase("Honorable")) {
					dischargeType.selectOption(1);
				}
				else if (dischargedAs.equalsIgnoreCase("OtherthanHonorable ")) {
					dischargeType.selectOption(2);
				}
				else if (dischargedAs.equalsIgnoreCase("Dishonorable")) {
					dischargeType.selectOption(3);
				}

			}

			else if (servedMilitary.equalsIgnoreCase("No")) {
				servedArmy.no();
			}

			saveScreenShot("n600", "SQ5_6"); clickContinueInSQ();
		}
		return this;
	}

}

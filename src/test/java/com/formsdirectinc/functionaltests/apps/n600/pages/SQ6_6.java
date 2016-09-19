
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_6 extends WizardPage {

	protected YesNo servedArmy;
	protected DateTag servedFrom, servedTo;
	protected MultiRadioOptions dischargeType;

	public SQ6_6(WebDriver driver) {
		super(driver);

	}

	public SQ6_6 militaryServices(Properties data, String servedMilitary,
			String dischargedAs) {

		if (!servedMilitary.equalsIgnoreCase("NA")) {

			servedArmy = new YesNo(driver,
					"applicant.motherInfo.militaryService.hasServedArmedForces");

			if (servedMilitary.equalsIgnoreCase("Yes")) {
				servedArmy.yes();

				servedFrom = new DateTag(driver,
						"applicant.motherInfo.militaryService.dateOfService.fromDate");
				servedFrom.selectDate(data.getProperty("fromDate"));
				servedTo = new DateTag(driver,
						"applicant.motherInfo.militaryService.dateOfService.toDate");
				servedTo.selectDate(data.getProperty("toDate"));

				dischargeType = new MultiRadioOptions(driver,

				"applicationData-applicant.motherInfo.militaryService.service");

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

			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

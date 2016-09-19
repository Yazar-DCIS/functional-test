package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_1_1 extends WizardPage {

	private YesNo currentlyServing, dischargedHonourably;
	private DateTag servedStartDate, servedEndDate;
	private MultiRadioOptions typeOfServices;
	private AdditionalInfoFields serviceBranch;

	public SQ2_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_1 militaryServingStatus(Properties n400copies,
			Properties data, String servedMilitary, int serviceCount,
			String dischargeHonourably, String serviceType) {

		if (servedMilitary.equalsIgnoreCase("Yes")
				|| servedMilitary.equalsIgnoreCase("No")) {
			currentlyServing = new YesNo(driver,
					"presenceInUs.currentlyInUsArmedForce");

			currentlyServing.setYesOrNo(servedMilitary);

			for (int i = 0; i < serviceCount; i++) {

				serviceBranch = new AdditionalInfoFields(driver,

				"applicationData-presenceInUs.periodOfServices[" + i
						+ "].branchOfService");
				serviceBranch.normalText(data.getProperty("State"));

				servedStartDate = new DateTag(driver,
						"presenceInUs.periodOfServices[" + i
								+ "].serviceDate.fromDate");
				servedStartDate.selectDate(data.getProperty("fromDate"));

				if (servedMilitary.equalsIgnoreCase("No")) {
					servedEndDate = new DateTag(driver,
							"presenceInUs.periodOfServices[" + i
									+ "].serviceDate.toDate");
					servedEndDate.selectDate(data.getProperty("toDate"));

					dischargedHonourably = new YesNo(driver,
							"presenceInUs.periodOfServices[" + i
									+ "].dischargedHonourably");

					if (dischargeHonourably.equalsIgnoreCase("Yes")) {
						dischargedHonourably.yes();
					}
					else if (dischargeHonourably.equalsIgnoreCase("No")) {
						dischargedHonourably.no();
					}

				}

				if (!dischargeHonourably.equalsIgnoreCase("No")) {
					typeOfServices = new MultiRadioOptions(driver,

					"applicationData-presenceInUs.periodOfServices[" + i
							+ "].typeOfServices");
					if (serviceType.equalsIgnoreCase("ActiveDuty")) {
						typeOfServices.selectOption(1);
					}
					else if (serviceType.equalsIgnoreCase("ReserveDuty")) {
						typeOfServices.selectOption(2);
					}
				}

				if (i < serviceCount - 1) {

					CommonInputClasses others = new CommonInputClasses(driver);
					others.addAnother();
				}

			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ2_1_1");
			
			 clickContinueInSQ();

		}
		return this;
	}

}

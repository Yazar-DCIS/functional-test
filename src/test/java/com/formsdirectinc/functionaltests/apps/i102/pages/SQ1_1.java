package com.formsdirectinc.functionaltests.apps.i102.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1 extends WizardPage {

	private MultiRadioOptions reasonForApplication, admittedToUS,
			admissionPort, portAdmissionDate;

	public SQ1_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_1 reasonforApplying(String reason, String arrivalToUS,
			String portOfAdmission, String dateOfPortAdmission) {

		if (!reason.equalsIgnoreCase("Skip")) {
			reasonForApplication = new MultiRadioOptions(driver,

			"applicationData-eligibilityInfo.suitCategory");
			if (reason.equalsIgnoreCase("replace_lost_I-94")) {

				reasonForApplication.selectOption(1);
			}
			else if (reason.equalsIgnoreCase("replace_lost_I-94W")) {
				reasonForApplication.selectOption(2);
			}

			else if (reason.equalsIgnoreCase("replace_stolen_I-94")) {
				reasonForApplication.selectOption(3);
			}

			else if (reason.equalsIgnoreCase("replace_stolen_I-94W")) {
				reasonForApplication.selectOption(4);
			}

			else if (reason.equalsIgnoreCase("I-94_mutilated")) {
				reasonForApplication.selectOption(5);
			}
			else if (reason.equalsIgnoreCase("I-94W_mutilated")) {
				reasonForApplication.selectOption(6);

			}
			else if (reason.equalsIgnoreCase("I-95_mutilated")) {
				reasonForApplication.selectOption(7);

			}
			else if (reason.equalsIgnoreCase("I-94_not_received")) {
				reasonForApplication.selectOption(8);

			}
			else if (reason.equalsIgnoreCase("other")) {
				reasonForApplication.selectOption(9);

			}

			if (reason.equalsIgnoreCase("replace_lost_I-94")
					|| reason.equalsIgnoreCase("replace_stolen_I-94")
					|| reason.equalsIgnoreCase("I-94_mutilated")
					|| reason.equalsIgnoreCase("I-94_not_received")) {

				admittedToUS = new MultiRadioOptions(driver,
						"applicationData-eligibilityInfo.lastArrivalToUs");

				if (arrivalToUS.equalsIgnoreCase("before_April_30_2013")) {
					admittedToUS.selectOption(1);
				}

				else if (arrivalToUS.equalsIgnoreCase("after_April_30_2013")) {
					admittedToUS.selectOption(2);
				}

			}

			if (reason.equalsIgnoreCase("replace_lost_I-94W")
					|| reason.equalsIgnoreCase("replace_stolen_I-94W")
					|| reason.equalsIgnoreCase("I-94W_mutilated")) {
				admissionPort = new MultiRadioOptions(driver,

				"applicationData-eligibilityInfo.portOfEntryToUs");
				if (portOfAdmission.equals("land_port")) {
					admissionPort.selectOption(1);

				}
				else if (portOfAdmission.equals("Sea_port")) {
					admissionPort.selectOption(2);
				}
				else if (portOfAdmission.equals("air_port")) {
					admissionPort.selectOption(3);
				}

				else if (portOfAdmission.equals("Sea_port")
						|| portOfAdmission.equals("air_port")) {
					portAdmissionDate = new MultiRadioOptions(driver,

					"applicationData-eligibilityInfo.admittedToUs");

					if (dateOfPortAdmission
							.equalsIgnoreCase("before_June_28_2010")) {
						portAdmissionDate.selectOption(1);
					}

					else if (dateOfPortAdmission
							.equalsIgnoreCase("after_June_28_2010")) {
						portAdmissionDate.selectOption(2);
					}
				}

			}

			saveScreenShot("I102", "SQ1_1"); clickContinueInSQ();

		}
		return this;

	}

}

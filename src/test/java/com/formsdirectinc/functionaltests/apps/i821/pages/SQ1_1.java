package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1 extends WizardPage {

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	
	private MultiRadioOptions registration_status;
	private YesNo late_registration;
	private YesNo bia_status;
	private YesNo reregister_status;

	public SQ1_1 registration_TPS(String eligiblity,
			String applyinglateregistration) {
		if (!eligiblity.equalsIgnoreCase("NA")) {

			registration_status = new MultiRadioOptions(driver,"applicationData-eligibilityDetails.optionApplies");
			late_registration = new YesNo(driver,"eligibilityDetails.applyingLateRegistration");
			if (eligiblity.equalsIgnoreCase("new_register")) {

				registration_status.selectOption(1);
				late_registration.setYesOrNo(applyinglateregistration);

			}
			else if (eligiblity.equalsIgnoreCase("re-register")) {

				registration_status.selectOption(2);

				late_registration.setYesOrNo(applyinglateregistration);
				
				bia_status = new YesNo(driver, "eligibilityDetails.tpsGranted");
				
				if (applyinglateregistration.equalsIgnoreCase("Yes")) {
					bia_status.yes();
					reregister_status = new YesNo(driver,"eligibilityDetails.firstReRegistration");
					reregister_status.setYesOrNo(applyinglateregistration);
				}
				else if (applyinglateregistration.equalsIgnoreCase("No")) {

					bia_status.no();
				}

			} else if (eligiblity.equalsIgnoreCase("None")) {

				registration_status.selectOption(3);

			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

}

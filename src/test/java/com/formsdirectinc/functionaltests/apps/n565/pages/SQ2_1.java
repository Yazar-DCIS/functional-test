package com.formsdirectinc.functionaltests.apps.n565.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	private MultiRadioOptions applicationType;
	private MultiRadioOptions formSpecific;

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 type_of_Application(String typeOfApplication,
			String becomeCitizenship) {

		if (!typeOfApplication.equalsIgnoreCase("NA")) {

			applicationType = new MultiRadioOptions(driver,
					"applicationData-formSpecific.typeOfApplication");

			if (typeOfApplication.equalsIgnoreCase("Naturalization")) {
				applicationType.selectOption(1);
				formSpecific = new MultiRadioOptions(driver,
						"applicationData-formSpecific.howYouBecomeCitizenship");
				if (becomeCitizenship.equalsIgnoreCase("By_Birth")) {
					formSpecific.selectOption(1);
				}
				else if (becomeCitizenship
						.equalsIgnoreCase("process_of naturalization")) {
					formSpecific.selectOption(2);
				}
			} else if (typeOfApplication.equalsIgnoreCase("Repatriation")) {
				applicationType.selectOption(2);
			} else if (typeOfApplication.equalsIgnoreCase("Intention")) {
				applicationType.selectOption(3);
			} else if (typeOfApplication
					.equalsIgnoreCase("CitizenshipBy_foreigncountry")) {
				applicationType.selectOption(4);
			}
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

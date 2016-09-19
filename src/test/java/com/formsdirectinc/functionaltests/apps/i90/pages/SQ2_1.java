package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Your Residence Type
 * @author Orina
 */

public class SQ2_1 extends WizardPage {

	private MultiRadioOptions residentStatus;
	
	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 residenceType(String greenCardType, String residenceType) {
		
			residentStatus = new MultiRadioOptions(driver,
					"applicationData-formSpecific.residentStatus");

			if (greenCardType.equalsIgnoreCase("2YearGreenCard")) {
				residentStatus.selectOption(1);
			}

			if (greenCardType.equalsIgnoreCase("10YearGreenCard")) {
				residentStatus.selectOption(2);

				MultiRadioOptions residentType = new MultiRadioOptions(driver,

				"applicationData-formSpecific.commuterStatus");

				if (residenceType.equalsIgnoreCase("regularResident")) {
					residentType.selectOption(1);
				}

				if (residenceType.equalsIgnoreCase("commuterStatus")) {
					residentType.selectOption(2);
				}
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		
		return this;
	}
}

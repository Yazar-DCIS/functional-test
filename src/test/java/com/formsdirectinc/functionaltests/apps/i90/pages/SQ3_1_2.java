package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Application Type
 *@author Orina
 */

public class SQ3_1_2 extends WizardPage {


	public SQ3_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_2 applicationType(Properties data, String visitThisPage,String statusOfCard) {
		if (visitThisPage.equalsIgnoreCase("yes")) {

			MultiRadioOptions cardStatusConditionalResident = new MultiRadioOptions(driver,
					"applicationData-formSpecific.cardStatusConditionalResident");

			if (statusOfCard.equalsIgnoreCase("cardLost")) {
				cardStatusConditionalResident.selectOption(1);
			}

			if (statusOfCard.equalsIgnoreCase("cardNeverReceived")) {
				cardStatusConditionalResident.selectOption(2);
			}

			if (statusOfCard.equalsIgnoreCase("cardMutilated")) {
				cardStatusConditionalResident.selectOption(3);
			}

			if (statusOfCard.equalsIgnoreCase("cardHasIncorrectData")) {
				cardStatusConditionalResident.selectOption(4);
			}

			if (statusOfCard.equalsIgnoreCase("nameChanged")) {
				
				cardStatusConditionalResident.selectOption(5);
				
				Name_FirstMiddleLast changedName = new Name_FirstMiddleLast(driver, "applicationData",
						"formSpecific.nameAppearedOnGC");
				changedName.setFirstNameField(data.getProperty("formSpecific.nameAppearedOnGC.first"));
				changedName.setMiddleNameField(data.getProperty("formSpecific.nameAppearedOnGC.middle"));
				changedName.setLastNameField(data.getProperty("formSpecific.nameAppearedOnGC.last"));
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}

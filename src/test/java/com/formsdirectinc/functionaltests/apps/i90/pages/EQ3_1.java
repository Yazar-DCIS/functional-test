package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * EQ3_1- reasonForApplication
 * @author Orina
 *
 */
public class EQ3_1 extends WizardPage {
	public MultiRadioOptions reasonForApplication;
	
	public EQ3_1(WebDriver driver) {
		super(driver);
	}

	public EQ3_1 reasonForApplication(String answer) {
		reasonForApplication = new MultiRadioOptions(driver,
				"applicationData-quiz.reasonForApplication");

		if (!answer.equalsIgnoreCase("NA")) {
		
			if (answer.equalsIgnoreCase("cardExpired")) {
				reasonForApplication.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("cardLost")) {
				reasonForApplication.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("cardNeverReceived")) {
				reasonForApplication.selectOption(3);
			}

			else if (answer.equalsIgnoreCase("cardMutilated")) {
				reasonForApplication.selectOption(4);
			}

			else if (answer.equalsIgnoreCase("cardInfoIncorrect")) {
				reasonForApplication.selectOption(5);
			}

			else if (answer.equalsIgnoreCase("cardNameChanged")) {
				reasonForApplication.selectOption(6);
			}

			else if (answer.equalsIgnoreCase("reasonUnknown")) {
				reasonForApplication.selectOption(7);
			}
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Continue");
		}

		return this;
	}
}

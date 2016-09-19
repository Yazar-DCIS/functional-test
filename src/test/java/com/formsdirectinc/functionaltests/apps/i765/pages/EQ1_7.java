package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_7 extends WizardPage {

	public MultiRadioOptions selectSpouseStatus;

	public EQ1_7(WebDriver driver) {
		super(driver);
	}

	public EQ1_7 spouseVisaStatus(String spouseStatus) throws Exception {
		if (!spouseStatus.equalsIgnoreCase("NA")) {
			
			selectSpouseStatus = new MultiRadioOptions(driver,
					"applicationData-quiz.spouseType");
			if (spouseStatus.equalsIgnoreCase("I140")) {
				selectSpouseStatus.selectOption(1);
			}
			else if (spouseStatus.equalsIgnoreCase("H1B")) {
				selectSpouseStatus.selectOption(2);
			}
			else if (spouseStatus.equalsIgnoreCase("None")) {
				selectSpouseStatus.selectOption(3);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

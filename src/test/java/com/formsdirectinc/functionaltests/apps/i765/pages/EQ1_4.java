package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_4 extends WizardPage {
	public MultiRadioOptions currentStatusOfApplicant;

	public EQ1_4(WebDriver driver) {
		super(driver);
	}

	public EQ1_4 currentStatusOfApplicant(String currentStatus)
			throws Exception {
		if (!currentStatus.equalsIgnoreCase("NA")) {
			
			currentStatusOfApplicant = new MultiRadioOptions(driver,
					"applicationData-quiz.currentStatus");
			if (currentStatus.equalsIgnoreCase("student")) {
				currentStatusOfApplicant.selectOption(1);
			}
			else if (currentStatus.equalsIgnoreCase("spouseOfVisaHolder")) {
				currentStatusOfApplicant.selectOption(2);
			}
			else if (currentStatus.equalsIgnoreCase("fianceOfUsCitizen")) {
				currentStatusOfApplicant.selectOption(3);
			}
			else if (currentStatus.equalsIgnoreCase("spouseOfUsCitizen")) {
				currentStatusOfApplicant.selectOption(4);
			}
			else if (currentStatus.equalsIgnoreCase("asylee")) {
				currentStatusOfApplicant.selectOption(5);
			}
			else if (currentStatus.equalsIgnoreCase("removalStatus")) {
				currentStatusOfApplicant.selectOption(6);
			}
			else if (currentStatus.equalsIgnoreCase("Other")) {
				currentStatusOfApplicant.selectOption(7);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for EQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_10 extends WizardPage {

	public MultiRadioOptions visaStatus;

	public EQ1_10(WebDriver driver) {
		super(driver);
	}

	public EQ1_10 I589Status(String selectI589Status) throws Exception {
		if (!selectI589Status.equalsIgnoreCase("NA")) {
			
			visaStatus = new MultiRadioOptions(driver,
					"applicationData-quiz.asylumAppnStatus");
			if (selectI589Status.equalsIgnoreCase("pendingI589")) {
				visaStatus.selectOption(1);
			}
			else if (selectI589Status.equalsIgnoreCase("approvedI589")) {
				visaStatus.selectOption(2);
			}
			else if (selectI589Status.equalsIgnoreCase("notApplied")) {
				visaStatus.selectOption(3);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

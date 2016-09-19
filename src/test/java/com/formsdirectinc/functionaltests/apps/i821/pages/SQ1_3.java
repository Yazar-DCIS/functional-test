package com.formsdirectinc.functionaltests.apps.i821.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {

	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	
	private CheckBox checkbox;

	public SQ1_3 attention_Required(String attention) {

		if (!attention.equalsIgnoreCase("NA")) {
			if (attention.equalsIgnoreCase("Attention")) {

				checkbox = new CheckBox(driver,
						"applicationData-eligibilityDetails.meetingConditions");
				checkbox.check();

				saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
			}
		}

		return this;

	}
	
	public SQ1_3 attention_RequiredUpdates(String attention) {

		if (!attention.equalsIgnoreCase("NA")) {
			if (attention.equalsIgnoreCase("Attention")) {

				YesNo checkbox = new YesNo(driver,
						"eligibilityDetails.meetingConditions");
				checkbox.yes();

				saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
			}
		}

		return this;

	}

}

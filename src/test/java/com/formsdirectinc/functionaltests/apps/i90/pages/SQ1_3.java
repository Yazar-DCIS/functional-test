package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90: About the Original Application
 * @author Orina
 */

public class SQ1_3 extends WizardPage {

	private MultiRadioOptions haveLeftUS;
	private YesNo appliedGreenCardWhileOutsideUS;

	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_3 originApplication(String appliedCardWhileOutsideUS, String anyTimeLeftUS) {
		

		appliedGreenCardWhileOutsideUS = new YesNo(driver, "formSpecific.whereWereYou");
			
			if (appliedCardWhileOutsideUS.equalsIgnoreCase("yes")) {
				appliedGreenCardWhileOutsideUS.yes();
			}

			if (appliedCardWhileOutsideUS.equalsIgnoreCase("no")) {
				appliedGreenCardWhileOutsideUS.no();

				haveLeftUS = new MultiRadioOptions(driver,"applicationData-formSpecific.explainedAboutAbsence");

				if (anyTimeLeftUS.equalsIgnoreCase("yes")) {
					haveLeftUS.selectOption(1);
				}

				if (anyTimeLeftUS.equalsIgnoreCase("no")) {
					haveLeftUS.selectOption(2);
				}
			
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}

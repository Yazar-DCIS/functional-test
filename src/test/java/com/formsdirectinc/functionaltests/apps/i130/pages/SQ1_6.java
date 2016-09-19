package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_6 extends WizardPage {

	private YesNo citizenAdopted;
	private MultiRadioOptions citizenMode;

	public SQ1_6(WebDriver driver) {
		super(driver);

	}

	public SQ1_6 applicantCitizenshipMode(String citizenThru, String adopted) {

		if (!citizenThru.equalsIgnoreCase("na")
				&& !adopted.equalsIgnoreCase("na")) {

			citizenMode = new MultiRadioOptions(driver,
					"applicationData-applicant.citizenshipMode");

			if (citizenThru.equalsIgnoreCase("Naturalization")) {
				citizenMode.selectOption(1);
			} else if (citizenThru.equalsIgnoreCase("Parents")) {
				citizenMode.selectOption(2);

				citizenAdopted = new YesNo(driver, "applicant.adopted");
				citizenAdopted.setYesOrNo(adopted);
				
			} else if (citizenThru.equalsIgnoreCase("Birth")) {
				citizenMode.selectOption(3);
			}

			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

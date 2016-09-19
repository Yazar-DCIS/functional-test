package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_16 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_16 extends WizardPage {

	private YesNo marriedBeforeStatus;

	public SQ1_16(WebDriver driver) {
		super(driver);

	}

	public SQ1_16 applicantPriorMarriage(String marriedBeforeAnswer) {

		if (!marriedBeforeAnswer.equalsIgnoreCase("na")) {

			marriedBeforeStatus = new YesNo(driver, "applicant.marriedBefore");

			marriedBeforeStatus.setYesOrNo(marriedBeforeAnswer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

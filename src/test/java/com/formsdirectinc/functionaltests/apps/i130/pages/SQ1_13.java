package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_13 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_13 extends WizardPage {

	private YesNo lprThroughAdoption;

	public SQ1_13(WebDriver driver) {
		super(driver);

	}

	public SQ1_13 permanentResidentThroughAdoption(
			String residentThroughAdoptionAnswer) {

		if (!residentThroughAdoptionAnswer.equalsIgnoreCase("na")) {

			lprThroughAdoption = new YesNo(driver,"applicant.lprThroughAdoption");
			lprThroughAdoption.setYesOrNo(residentThroughAdoptionAnswer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

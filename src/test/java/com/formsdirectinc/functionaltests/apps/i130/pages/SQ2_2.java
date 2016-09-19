package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	private YesNo relatedAdoption;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2 relatedByAdoption(String relatedByAdoption) {

		if (!relatedByAdoption.equalsIgnoreCase("na")) {
			relatedAdoption = new YesNo(driver, "relative.relatedByAdoption");
			relatedAdoption.setYesOrNo(relatedByAdoption);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

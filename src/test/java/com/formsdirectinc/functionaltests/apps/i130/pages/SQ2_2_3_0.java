package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2_3_0 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_3_0 extends WizardPage {

	private YesNo marriedWhenChildBorn;

	public SQ2_2_3_0(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_3_0 marriedWhenChildBorn(String marriedOnChildBirth) {
		if (!marriedOnChildBirth.equalsIgnoreCase("na")) {
			marriedWhenChildBorn = new YesNo(driver,
					"relative.marriedWhenChildBorn");
			marriedWhenChildBorn.setYesOrNo(marriedOnChildBirth);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

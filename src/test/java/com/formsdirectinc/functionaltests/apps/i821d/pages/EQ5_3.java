package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_3 extends WizardPage {

	private YesNo advanceParoleForAllTrips;

	public EQ5_3(WebDriver driver) {
		super(driver);
	}

	public EQ5_3 advanceParoleForAllTrips(String advanceParole)
			throws Exception {

		if (!advanceParole.equalsIgnoreCase("skip")) {

			advanceParoleForAllTrips = new YesNo(driver,
					"quiz.advanceParoleForAllTrips");
			advanceParoleForAllTrips.setYesOrNo(advanceParole);
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

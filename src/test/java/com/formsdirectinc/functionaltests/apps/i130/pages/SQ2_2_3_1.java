package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_3_1 extends WizardPage {

	private YesNo childLegimation;

	public SQ2_2_3_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_3_1 childsLegitimatedbeforeEighteenthBirthday(
			String childLegimated) {

		if (!childLegimated.equalsIgnoreCase("na")) {
			childLegimation = new YesNo(driver,
					"relative.childsLegitimatedbeforeEighteenthBirthday");

			childLegimation.setYesOrNo(childLegimated);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

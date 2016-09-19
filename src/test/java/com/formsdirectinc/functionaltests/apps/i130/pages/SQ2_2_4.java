package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_4 extends WizardPage {

	private YesNo marriedBeforeChildTurn18;

	public SQ2_2_4(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_4 marriageBeforeChildsEighteenthBirthday(String marriedBefore18) {

		if (!marriedBefore18.equalsIgnoreCase("na")) {
			marriedBeforeChildTurn18 = new YesNo(driver,
					"relative.marriageBeforeChildsEighteenthBirthday");
			marriedBeforeChildTurn18.setYesOrNo(marriedBefore18);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

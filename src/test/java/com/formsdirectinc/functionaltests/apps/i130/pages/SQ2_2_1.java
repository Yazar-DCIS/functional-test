package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_1 extends WizardPage {

	private YesNo atleastOneCommonParent;

	public SQ2_2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_1 atleastOneCommonParent(String oneCommonParent) {

		if (!oneCommonParent.equalsIgnoreCase("na")) {
			atleastOneCommonParent = new YesNo(driver,
					"relative.atleastOneCommonParent");
			atleastOneCommonParent.setYesOrNo(oneCommonParent);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

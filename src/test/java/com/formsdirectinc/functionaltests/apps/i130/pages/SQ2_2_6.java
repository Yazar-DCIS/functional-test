package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_6 extends WizardPage {

	private YesNo parentChildRelationship;

	public SQ2_2_6(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_6 parentChildRelationship(String hadParentChildRelationship) {

		if (!hadParentChildRelationship.equalsIgnoreCase("na")) {
			parentChildRelationship = new YesNo(driver,
					"relative.parentChildRelationship");

			parentChildRelationship.setYesOrNo(hadParentChildRelationship);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

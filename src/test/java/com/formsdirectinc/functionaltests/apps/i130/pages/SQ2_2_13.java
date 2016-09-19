package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2_13 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_13 extends WizardPage {

	private YesNo parentChildRelationship21Years;

	public SQ2_2_13(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_13 parentChildRelationship21Years(String relation21Years) {
		if (!relation21Years.equalsIgnoreCase("na")) {

			parentChildRelationship21Years = new YesNo(driver,
					"relative.parentChildRelationshipReachedTwentyOneYears");

			parentChildRelationship21Years.setYesOrNo(relation21Years);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

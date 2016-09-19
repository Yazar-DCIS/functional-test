package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1_1 extends WizardPage {

	private YesNo notUsedOtherNames;

	public SQ2_1_1(WebDriver driver) {
		super(driver);

	}

	public void notUsedOtherNames(String type) {
		if (type.equalsIgnoreCase("principal")) {
			notUsedOtherNames = new YesNo(driver,
					"principalApplicant.haveUsedOtherNames");
		} else {
			notUsedOtherNames = new YesNo(driver,
					"beneficiaryApplicant.haveUsedOtherNames");
		}

		notUsedOtherNames.no();

	}

	public void notUsedOtherNamesID(String type) {
		if (type.equalsIgnoreCase("principal")) {
			notUsedOtherNames = new YesNo(driver,
					"principalApplicant.otherNames.hasUsedOtherNames");
		} else {
			notUsedOtherNames = new YesNo(driver,
					"beneficiaryApplicant.otherNames.hasUsedOtherNames");
		}

		notUsedOtherNames.no();

	}

}

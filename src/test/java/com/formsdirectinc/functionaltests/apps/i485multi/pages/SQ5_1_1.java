package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1_1 extends WizardPage {

	private YesNo contribution;

	public SQ5_1_1(WebDriver driver) {
		super(driver);

	}

	public void contributionToSpouse(String answer) {

		contribution = new YesNo(driver,
				"principalFamilyMembers.spouseInfo.contributionsToSpouse");
		contribution.setYesOrNo(answer);
		

	}

}

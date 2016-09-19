
package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_3 extends WizardPage {

	protected YesNo wereParentsMarriedTimeOfBirth, wereParentsMarriedAfter,
			doParentsRegularlyReside;

	public SQ4_3(WebDriver driver) {
		super(driver);

	}

	public SQ4_3 parentsInfo(String parentInfo) {

		if (!parentInfo.equalsIgnoreCase("NA")) {

			wereParentsMarriedTimeOfBirth = new YesNo(driver,"applicant.additionalInfo.parentsMarriedTimeOfBirth");
			wereParentsMarriedTimeOfBirth.setYesOrNo(parentInfo);
			wereParentsMarriedAfter = new YesNo(driver,"applicant.additionalInfo.parentsMarriedAfter");
			wereParentsMarriedAfter.setYesOrNo(parentInfo);
			doParentsRegularlyReside = new YesNo(driver,"applicant.additionalInfo.parentsRegularlyReside");
			doParentsRegularlyReside.setYesOrNo(parentInfo);
			
			saveScreenShot("n600", "SQ4_3"); clickContinueInSQ();
		}

		return this;
	}

}

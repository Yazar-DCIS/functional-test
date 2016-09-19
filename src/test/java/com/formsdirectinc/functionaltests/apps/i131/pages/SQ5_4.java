package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ5_4 extends WizardPage {

	public SQ5_4(WebDriver driver) {
		super(driver);
	}

	public SQ5_4 travelDetails(Properties data, String reacquiredNationality,
			String acquiredNewNationality, String grantedRefugee) {
		if (!reacquiredNationality.equalsIgnoreCase("NA")) {

			CrimeDetails travelRelated=new CrimeDetails(driver);
			travelRelated.informationRelatedToCrime("i131", "applicant.reacquiredNationality", reacquiredNationality);
			travelRelated.informationRelatedToCrime("i131", "applicant.acquiredNewNationality", acquiredNewNationality);
			travelRelated.informationRelatedToCrime("i131", "applicant.grantedRefugee", grantedRefugee);
			
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_6 extends WizardPage {

	public SQ6_6(WebDriver driver) {
		super(driver);
	}

	public SQ6_6 setOtherViolations(String otherviolations, Properties data) {
		if (!otherviolations.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.communicableDisease", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.physicalOrMentalDisorder", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.practicePolygamy", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.civilMonetaryPenalties", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.violationOfSection274C", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.detainedOrRetained", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.trafficedIn", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.unlawfulTraffic", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.alienUnlawfulTraffic", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.assistedUnlawfulTraffic", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.benifiFromUnlawful", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.drugAbuser", otherviolations);
			
			
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}

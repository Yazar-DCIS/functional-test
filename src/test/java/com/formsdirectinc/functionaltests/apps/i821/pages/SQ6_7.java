package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_7 extends WizardPage {

	public SQ6_7(WebDriver driver) {
		super(driver);
	}


	public SQ6_7 setOther_Violations(String otherviolations, Properties data) {
		if (!otherviolations.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.unlawfulVoteInUS", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.claimedUSCitizen", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.underAgeHelp", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.underAgeHostilities", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.victimsOfTraffic", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.colludedHumanTraffic", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.religiousViolation", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.spourOrChildOfAlien", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.areYouAlienOrRelation", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.engagedMoneyLaundary", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.moneyLaundaryAider", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.humanTrafficBenefit", otherviolations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.otherViolations.filedAsylumApplication", otherviolations);
			
		
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

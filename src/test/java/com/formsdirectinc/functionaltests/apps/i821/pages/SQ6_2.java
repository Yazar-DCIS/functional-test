package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_2 extends WizardPage {

	public SQ6_2(WebDriver driver) {
		super(driver);
	}

	public SQ6_2 setcrimeDetails(String crimedetails, Properties data) {
		if (!crimedetails.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.convictedOfFelony", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.misdemeanorCommit", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.convictedByFinalJudgment", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.convictedNonPoliticalCrime", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.convictedTwoOrMoreOffense", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.arrestedCitedCharged", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.beneficiaryPardon", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.convictedCriminalOffense", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.assistedOtherPersonInVoilation", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.enteredUsaInStowAway", crimedetails);
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();

		}
		return this;
	}
}

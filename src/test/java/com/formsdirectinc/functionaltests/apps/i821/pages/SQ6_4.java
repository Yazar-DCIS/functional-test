package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_4 extends WizardPage {

	public SQ6_4(WebDriver driver) {
		super(driver);
	}


	public SQ6_4 your_Affiliations(String affiliations, Properties data) {
		if (!affiliations.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.affiliations.engagedInTerroristActivities", affiliations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.affiliations.engagedPotentiallySeriousAdverseForeignPolicy", affiliations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.affiliations.participatedInNaziPersecution", affiliations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.affiliations.orderedIncitedAssisted", affiliations);
			crimeRelated.informationRelatedToCrime("i821", "applicant.affiliations.memberCommunistOrTotalitarianParty", affiliations);
			
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}
}

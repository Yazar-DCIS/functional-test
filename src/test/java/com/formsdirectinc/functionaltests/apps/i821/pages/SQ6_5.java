package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_5 extends WizardPage {

	public SQ6_5(WebDriver driver) {
		super(driver);
	}

	
	public SQ6_5 set_Miscellaneous(String miscellaneous, Properties data) {
		if (!miscellaneous.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.servedInMilitaryUnit", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.servedInPrison", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.memberInAnyGroup", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.providingWeaponsToPersons", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.typeOfMilitaryParamilitary", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.engageSolelyPrincipally", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.exportedGoods", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.otherUnlawfulActivity", miscellaneous);
			crimeRelated.informationRelatedToCrime("i821", "applicant.miscellaneous.oppositionToGovt", miscellaneous);
			
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}

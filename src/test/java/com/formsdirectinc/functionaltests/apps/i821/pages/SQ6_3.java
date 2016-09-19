package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;


/**
 * Page model for SQ6_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_3 extends WizardPage {

	public SQ6_3(WebDriver driver) {
		super(driver);
	}


	public SQ6_3 setcriminal_Charges(String crimedetails, Properties data) {
		if (!crimedetails.equalsIgnoreCase("NA")) {
			
			CrimeDetails crimeRelated=new CrimeDetails(driver);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.actsInvolvingTorture", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.killingAnyPerson", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.intentionallyInJuring", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.relationsWithThreatenedPersons", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.limitingOrDenying", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.dangerToSecurityOfUsa", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.controlledSubstanceAct", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.violationOfLaw", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.conspiracyToViolent", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.procurementOfProstitution", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.procureAttempt", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.proceedProstitution", crimedetails);
			crimeRelated.informationRelatedToCrime("i821", "applicant.crimeDetails.involvedInCommercialVice", crimedetails);
			
		
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.i821d.pages;

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

	public SQ6_3 criminalCharges(String criminalHistory, Properties data)
			throws Exception {

		if (!criminalHistory.equalsIgnoreCase("Skip")) {
			
			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.actsInvolvingTorture", criminalHistory);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.killingAnyPerson", criminalHistory);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.intentionallyInJuring", criminalHistory);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.relationsWithThreatenedPersons", criminalHistory);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.helpArmedForce", criminalHistory);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.combatServices", criminalHistory);
		
		}
		return this;

	}
}

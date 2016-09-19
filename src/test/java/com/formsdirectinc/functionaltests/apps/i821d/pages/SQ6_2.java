package com.formsdirectinc.functionaltests.apps.i821d.pages;

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

	public SQ6_2 criminalCharges(String criminalCharges, Properties data)
			throws Exception {

		if (!criminalCharges.equalsIgnoreCase("Skip")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.convictedOfFelony", criminalCharges);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.convictedNonPoliticalCrime", criminalCharges);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.convictedByFinalJudgment", criminalCharges);
			crimes.informationRelatedToCrime("i821d", "applicant.crimeDetails.convictedTwoOrMoreOffense", criminalCharges);

		}
		return this;
	}
}

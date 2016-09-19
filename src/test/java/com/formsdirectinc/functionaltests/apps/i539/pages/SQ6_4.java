package com.formsdirectinc.functionaltests.apps.i539.pages;

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

	public void criminalHistory() {
		
		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i539", "applicant.arrestedForCriminalOffense", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.participatedOrHelpedCriminal", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.killingAnyPerson", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.injuringAnyPerson", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.engagingAnyKindSexualContact", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.exerciseReligiousBeliefs", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.servedOrMember", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.servedInAnyPrison", "no");
		
	
	}

}

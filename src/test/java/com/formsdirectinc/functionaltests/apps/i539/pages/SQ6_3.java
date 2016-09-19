package com.formsdirectinc.functionaltests.apps.i539.pages;

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

	public void pastImmigrationViolations() {
		
		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i539", "applicant.removalProceedings", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.violationOfTerms", "no");
		

	}

}

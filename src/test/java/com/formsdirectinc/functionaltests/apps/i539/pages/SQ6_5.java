package com.formsdirectinc.functionaltests.apps.i539.pages;

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

	public void weaponRelatedActivities() {
		
		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i539", "applicant.usedWeapon", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.selledWeapon", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.weaponTraining", "no");
		

	}

}

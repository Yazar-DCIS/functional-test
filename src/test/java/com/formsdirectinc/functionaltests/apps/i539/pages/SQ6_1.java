package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_1 extends WizardPage {


	public SQ6_1(WebDriver driver) {
		super(driver);
	}

	public void immigrationHistory() {
		
		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i539", "applicant.immigrationVisa", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.immigrantPetitionFiled", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.everFiledi485", "no");
		crimeinfo.informationRelatedToCrime("i539", "applicant.exchangeVisitor", "no");
		
		}

}

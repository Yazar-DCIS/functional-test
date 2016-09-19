package com.formsdirectinc.functionaltests.apps.i485.pages;

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

	public void criminalIntent(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.engagedInEspionage", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.oppositionToGovernment", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.violateTheLaw", "no");
		
		
	}

}

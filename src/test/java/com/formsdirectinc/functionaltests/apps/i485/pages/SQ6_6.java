package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_6 extends WizardPage {

	
	public SQ6_6(WebDriver driver) {
		super(driver);

	}

	public void immigrationViolation(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.beenDeportedFromUS", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.leftUS", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.beenJNonimmigrant", "no");
		
		
	}

}

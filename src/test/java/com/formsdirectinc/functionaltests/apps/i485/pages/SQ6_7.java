package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_7 extends WizardPage {

	

	public SQ6_7(WebDriver driver) {
		super(driver);

	}

	public void otherViolations(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.civilPenalty", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.withholdingCustody", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.associationWithNaziGovernment", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.practicePolygamy", "no");
		
		
	}

}

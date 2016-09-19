package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

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

	public void miscellaneous(Properties data) {
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.receivedPublicAssistance", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.memberOfCommunistParty", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.illegalActivity", "no");
		
	}

}

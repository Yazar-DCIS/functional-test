package com.formsdirectinc.functionaltests.apps.i485.pages;

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

	public void criminalHistory1(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.beenProstitute", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.illegalGambling", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.encouragedIllegalEntry", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.illicitlyTrafficked", "no");
				
	}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_5_1 extends WizardPage {


	public SQ6_5_1(WebDriver driver) {
		super(driver);

	}

	public void miscellaneous1(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.tortureOrGenocideActs", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.killingAnyPerson", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.injuringAnyPerson", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.forcedOrThreatenedSex", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.denyingPersonsAbility", "no");
		
		
	}

}

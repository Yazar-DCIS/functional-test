package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_7_1 extends WizardPage {

	
	public SQ6_7_1(WebDriver driver) {
		super(driver);

	}

	public void miscellaneous2(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.servedInMilitary", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.servedInPrison", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.usedWeaponAgainstPersons", "no");
		
		}

}

package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_7_2 extends WizardPage {

	

	public SQ6_7_2(WebDriver driver) {
		super(driver);

	}

	public void miscellaneous3(Properties data) {
		
		CrimeDetails crimeInfo=new CrimeDetails(driver);
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.assistedSellingWeapons", "no");
		crimeInfo.informationRelatedToCrime("i485", "processingInfo.receivedAnyWeaponTraining", "no");
		
	}

}

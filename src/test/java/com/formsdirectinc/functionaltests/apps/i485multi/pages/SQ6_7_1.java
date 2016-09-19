package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	public void miscellaneous(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.servedInMilitary", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.servedInPrison", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.usedWeaponAgainstPersons", "no");
	

	}

}

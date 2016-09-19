package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_2 extends WizardPage {

	public SQ6_2(WebDriver driver) {
		super(driver);

	}

	public void criminalHistory(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.committedCrime", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.beenArrested", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.beenBeneficiary", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.exercisedDiplomaticImmunity", "no");
	
	}

}

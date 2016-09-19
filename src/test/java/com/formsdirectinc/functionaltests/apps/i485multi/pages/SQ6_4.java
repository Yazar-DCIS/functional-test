package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	public void criminalIntent(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.engagedInEspionage", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.oppositionToGovernment", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.violateTheLaw", "no");
		

	}

}

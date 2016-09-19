package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	public void immigrationViolations(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.beenDeportedFromUS", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.leftUS", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.beenJNonimmigrant", "no");
		

	}

}

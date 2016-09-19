package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	public void immigrationViolations(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.civilPenalty", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.withholdingCustody", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.associationWithNaziGovernment", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
			type+ "FormSpecific.processingInfo.practicePolygamy", "no");
		

	}

}

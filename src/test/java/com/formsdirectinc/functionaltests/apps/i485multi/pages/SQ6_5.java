package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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

	public void miscellaneous(String type) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i485multi", 
					type+ "FormSpecific.processingInfo.receivedPublicAssistance", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.illegalActivity", "no");
		crimeinfo.informationRelatedToCrime("i485multi", 
				type+ "FormSpecific.processingInfo.memberOfCommunistParty", "no");
		

	}

}

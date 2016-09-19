package com.formsdirectinc.functionaltests.apps.i751.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1 extends WizardPage {

	
	public SQ3_1(WebDriver driver) {
		super(driver);

	}

	public void immigrationProceedings() {
		
		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationRelatedToCrime("i751", "formSpecific.removalProceedings", "no");
		crimeinfo.informationRelatedToCrime("i751", "formSpecific.feePaid", "no");
		crimeinfo.informationRelatedToCrime("i751", "formSpecific.everArrested", "no");
		crimeinfo.informationOnCrimeWithoutExplain("formSpecific.otherAddress", "no");
		

	}

}

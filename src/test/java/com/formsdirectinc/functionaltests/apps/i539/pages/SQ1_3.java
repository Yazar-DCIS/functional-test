package com.formsdirectinc.functionaltests.apps.i539.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3 extends WizardPage {


	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	public void set_NonImmigrantStatus() {
		
		SelectElement currentStatus=new SelectElement(driver, 
								"applicationData-applicant.currentNonImmigrantStatus1-currentstatus");
		currentStatus.sendValuesUsingElementID("B-1/B-2");
		
	}

}

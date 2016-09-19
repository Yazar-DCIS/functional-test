package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_9 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ6_9 extends WizardPage {

	
	

	private YesNo previousAffidavits;

	public SQ6_9(WebDriver driver) {
		super(driver);

	}

	public void previousAffidavit(String type) {

		previousAffidavits = new YesNo(driver, type
				+ "FormSpecific.processingInfo.affidavitOfSupport");
		previousAffidavits.no();

	}

}

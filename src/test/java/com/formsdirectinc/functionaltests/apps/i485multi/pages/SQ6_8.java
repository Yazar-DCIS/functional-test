package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_8 extends WizardPage {

	
	

	private YesNo previousPetitions;

	public SQ6_8(WebDriver driver) {
		super(driver);

	}

	public void previousPetitions(String type) {

		previousPetitions = new YesNo(driver, type
				+ "FormSpecific.processingInfo.immigrantVisaPetition");
		previousPetitions.no();

	}

}

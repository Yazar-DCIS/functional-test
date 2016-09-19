package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ9_1 extends WizardPage {

	
	

	private YesNo livedInUSLawfully;

	public SQ9_1(WebDriver driver) {
		super(driver);

	}

	public void livedInUSLawfully(String type) {

		livedInUSLawfully = new YesNo(driver, type
				+ "FormSpecific.travelDocument.hasLivedInUSUnlawfully");
		livedInUSLawfully.no();

	}

}

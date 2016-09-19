package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ1_6 extends WizardPage {

	
	

	private YesNo sponsorRelated;

	public SQ1_6(WebDriver driver) {
		super(driver);

	}

	public void sponsorImmediateRelative() {

		sponsorRelated = new YesNo(driver, "principalQuiz.immediateRelative");
		sponsorRelated.yes();

	}

}

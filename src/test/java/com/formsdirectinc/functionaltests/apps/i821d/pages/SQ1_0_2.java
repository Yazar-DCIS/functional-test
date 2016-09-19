package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_0_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_0_2 extends WizardPage {

	public SQ1_0_2(WebDriver driver) {
		super(driver);
	}

	
	

	public SQ1_0_2 attention_Required(String visitThisPage) throws Exception {
		if (!visitThisPage.equalsIgnoreCase("Skip")) {
			
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInSQ();
				
		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i131.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for StopAttentionPage Details
 * @author:Orina<br> Revision: $Rev$
 */

public class StopAttentionPage extends WizardPage {

	public StopAttentionPage(WebDriver driver) {
		super(driver);
	}

	public void attentionRequired() {
		saveScreenShot("i131","SorryPage");
		System.out.println( pageHeader());
	}

	

}

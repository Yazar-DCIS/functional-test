package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DropDown;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_9 extends WizardPage {
	private DropDown coa;

	public SQ2_9(WebDriver driver) {
		super(driver);
	}

	public SQ2_9 COA(Properties data) {
		
		coa = new DropDown(driver, "applicant.status1");
		coa.selectValue(data.getProperty("I131_COA"));
		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}
}
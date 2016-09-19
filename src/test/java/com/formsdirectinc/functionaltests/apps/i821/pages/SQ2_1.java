package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	
	private CommonInputClasses addName;

	public SQ2_1 name_Detail(Properties data) {

		addName = new CommonInputClasses(driver);
		addName.applicantNameDetails("applicant.name", data);

		saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1 extends WizardPage {

	private CommonInputClasses nameTag;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 setNameFields(Properties data) throws Exception {
		
		nameTag = new CommonInputClasses(driver);
		nameTag.applicantNameDetails("applicant.name", data);

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

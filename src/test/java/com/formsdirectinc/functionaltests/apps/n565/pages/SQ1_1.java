package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast nameTag;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 setNameOnDocument(Properties data) {
		nameTag = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		nameTag.setFirstNameField(data.getProperty("FirstName"));
		nameTag.setMiddleNameField(data.getProperty("MiddleName"));
		nameTag.setLastNameField(data.getProperty("LastName"));

		saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

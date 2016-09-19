package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.newtags.WizardPage;


/**
 * Parent Information
 * @author Orina
 *
 */
public class SQ1_1_4 extends WizardPage {

	public SQ1_1_4(WebDriver driver) {
		super(driver);
	}

	
	public SQ1_1_4 setParentName(Properties data) {

		Name_FirstMiddleLast parentName=new Name_FirstMiddleLast(driver, "applicationData", "applicant");
		parentName.setFatherNameField(data.getProperty("applicant.fatherFirstName"));
		parentName.setMotherNameField(data.getProperty("applicant.motherFirstName"));
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

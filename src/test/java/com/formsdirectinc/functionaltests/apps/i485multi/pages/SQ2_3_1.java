package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3_1 extends WizardPage {

	
	

	private Name_FirstMiddleLast applicantParentsName;
	private YesNo parentsAlive;

	public SQ2_3_1(WebDriver driver) {
		super(driver);

	}

	public void applicantParentsInformation(Properties data) {

		applicantParentsName = new Name_FirstMiddleLast(driver,
				"applicationData", "principalApplicant.fatherInfo.name");
		applicantParentsName.setFirstNameField(data.getProperty("FatherName"));
		applicantParentsName.setLastNameField(data.getProperty("LastName3"));

		parentsAlive = new YesNo(driver, "principalApplicant.fatherInfo.alive");
		parentsAlive.no();

		applicantParentsName = new Name_FirstMiddleLast(driver,
				"applicationData", "principalApplicant.motherInfo.name");
		applicantParentsName.setFirstNameField(data.getProperty("MotherName"));
		applicantParentsName.setLastNameField(data.getProperty("FirstName3"));

		parentsAlive = new YesNo(driver, "principalApplicant.motherInfo.alive");
		parentsAlive.no();
	}

	public void beneficiaryParentsInformation(Properties data) {

		applicantParentsName = new Name_FirstMiddleLast(driver,
				"applicationData", "beneficiaryApplicant.fatherInfo.name");
		applicantParentsName.setFirstNameField(data.getProperty("OtherFirst"));
		applicantParentsName.setLastNameField(data.getProperty("FirstName4"));

		parentsAlive = new YesNo(driver,
				"beneficiaryApplicant.fatherInfo.alive");
		parentsAlive.no();

		applicantParentsName = new Name_FirstMiddleLast(driver,
				"applicationData", "beneficiaryApplicant.motherInfo.name");
		applicantParentsName.setFirstNameField(data.getProperty("OtherMiddle"));
		applicantParentsName.setLastNameField(data.getProperty("LastName4"));

		parentsAlive = new YesNo(driver,
				"beneficiaryApplicant.motherInfo.alive");
		parentsAlive.no();
	}

}

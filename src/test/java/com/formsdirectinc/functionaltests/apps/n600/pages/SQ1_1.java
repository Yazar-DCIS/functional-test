package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
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

	public void setNameFields(Properties n600copies, Properties data) {

		

		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation.verifyPageSectionHeader(
					n600copies.getProperty("sectionHeader.sq1.1"),
					"section-1.1.1");
			copyValidation.verifyExplainThisText(
					n600copies.getProperty("sectionHeader.explainThis.sq1.1"),
					"section-1.1.1",
					n600copies.getProperty("elementID.explainThis.sq1.1"));
			for (int i = 0; i <= 2; i++) {
				copyValidation.verifyMultipleLabelText(
						n600copies.getProperty("name.sq1.1_" + i),
						"section-1.1.1", i);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		nameTag = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		nameTag.setFirstNameField(data.getProperty("FirstName"));
		nameTag.setMiddleNameField(data.getProperty("MiddleName"));
		nameTag.setLastNameField(data.getProperty("LastName"));
		saveScreenShot("n600", "SQ1_1"); clickContinueInSQ();
	}

}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
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

	public void applicantLegalName(Properties data, Properties n400copies) {

		

		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.1.pageheader"));
			copyValidation.verifyPageSectionHeader(
					n400copies.getProperty("SQ-1.1.pagetext.1") + " "
							+ n400copies.getProperty("label-ExplainThis"),
					"section-1.1.1");
			copyValidation
					.verifyExplainThisText(
							n400copies
									.getProperty("control.explainthis.title.1.1a.header")
									+ " "
									+ n400copies
											.getProperty("control.explainthis.help.1.1a.header"),
							"section-1.1.1", "applicant.name-header");
			for (int i = 0; i <= 2; i++) {
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("name.sq1.1_" + i),
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
		
		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_1");
		
		 clickContinueInSQ();

	}

}

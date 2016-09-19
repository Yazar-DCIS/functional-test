package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_4 extends WizardPage {

	private YesNo nameChange;
	private Name_FirstMiddleLast name;

	public SQ1_4(WebDriver driver) {
		super(driver);

	}

	public SQ1_4 legallyChangeName(Properties copies,
			String nameChangeRequired, Properties data) {

		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		
		try {
			copyValidation.verifyPageTableHeader(copies
					.getProperty("SQ-1.4.pageheader"));
			copyValidation.verifyPageLabelText(
					copies.getProperty("SQ-1.4.pagetext.1") + " "
							+ copies.getProperty("label-ExplainThis"),
					"section-1.4.1");
			/*copyValidation
					.verifyExplainThisText(
							copies.getProperty("control.explainthis.title.legallyChanged")
									+ "<br>"
									+ copies.getProperty("control.explainthis.help.legallyChanged"),
							"section-1.4.1", "legallyChanged");*/

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		nameChange = new YesNo(driver, "personalDetails.legallyChangeName");

		if (nameChangeRequired.equalsIgnoreCase("No")) {
			nameChange.no();
		}

		else if (nameChangeRequired.equalsIgnoreCase("Yes")) {
			nameChange.yes();

			
			try {
				copyValidation.verifyPageSectionHeader(
						copies.getProperty("SQ-1.4.pagetext.2") + " "
								+ copies.getProperty("label-ExplainThis"),
						"section-1.4.2");
				/*copyValidation
						.verifyExplainThisText(
								copies.getProperty("control.explainthis.title.1.4a.header")
										+ "<br>"
										+ copies.getProperty("control.explainthis.help.1.4a.header"),
								"section-1.4.2",
								"personalDetails.legalName-header");*/

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			name = new Name_FirstMiddleLast(driver, "applicationData",
					"personalDetails.legalName");
			name.setFirstNameField(data.getProperty("NewFirstName"));
			name.setLastNameField(data.getProperty("NewLastName"));
			

		}

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_4");
		
		 clickContinueInSQ();
		return this;
	}

}

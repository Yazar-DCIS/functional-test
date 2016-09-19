package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_8_1 extends WizardPage {

	public SQ1_8_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_8_1 applicantInEligible(Properties n400copies,
			String visitThisPage) {

		if (visitThisPage.equalsIgnoreCase("Yes")) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);

			try {

				copyValidation.verifyPageTableHeader(n400copies
						.getProperty("SQ-1.8.1.pageheader"));
				copyValidation
						.verifySorryPageText(
								n400copies.getProperty("SQ-1.8.1.pagetext.1")
										+ n400copies
												.getProperty("SQ-1.8.1.pagetext.2")
										+ n400copies
												.getProperty("SQ-1.8.1.pagetext.3")
										+ n400copies
												.getProperty("SQ-1.8.1.pagetext.4"),
								"section-1.8.1.1");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_8_1");
			
			 clickContinueInSQ();
		}

		return this;
	}

}

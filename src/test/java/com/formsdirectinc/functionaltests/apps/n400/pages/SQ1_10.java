package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_10 extends WizardPage {

	private YesNo ssnInfo;
	private Numbers securityNumber;

	public SQ1_10(WebDriver driver) {
		super(driver);

	}

	public SQ1_10 ssnDetails(Properties copies, Properties data, String status) {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		try {
			copyValidation.verifyPageTableHeader(copies
					.getProperty("SQ-1.10.pageheader"));
			copyValidation.verifyMultipleLabelText(
					copies.getProperty("SQ-1.10.pagetext.1"), "section-1.10.1",
					0);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		ssnInfo = new YesNo(driver, "formSpecific.haveSSN");

		if (status.equalsIgnoreCase("Yes")) {
			ssnInfo.yes();

			try {
				copyValidation.verifyMultipleLabelText(
						copies.getProperty("SQ-1.10.pagetext.2"),
						"section-1.10.2", 0);

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			securityNumber = new Numbers(driver,
					"applicationData-applicant.SSN");
			securityNumber.setSocialSecurityNumber(data.getProperty("SSN_1"),
					data.getProperty("SSN_2"), data.getProperty("SSN_3"));

		}

		else if (status.equalsIgnoreCase("No")) {
			ssnInfo.no();
		}

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_10");
		
		 clickContinueInSQ();
		return this;
	}

}

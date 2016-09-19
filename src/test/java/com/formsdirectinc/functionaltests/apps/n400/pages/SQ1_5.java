package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5 extends WizardPage {

	private YesNo residenceOutsideUS;

	public SQ1_5(WebDriver driver) {
		super(driver);

	}

	public SQ1_5 residenceUS(Properties copies, String resideOutsideUS) {

		
		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation.verifyPageTableHeader(copies
					.getProperty("SQ-1.5.pageheader"));
			copyValidation.verifyPageLabelText(
					copies.getProperty("SQ-1.5.pagetext.1"), "section-1.5.1");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		residenceOutsideUS = new YesNo(driver, "formSpecific.outsideUS");
		residenceOutsideUS.setYesOrNo(resideOutsideUS);
		
		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_5");
		
		 clickContinueInSQ();
		return this;
	}

}

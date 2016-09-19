package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_2 extends WizardPage {

	public YesNo areYouUSNational;
	public Sites site;

	public EQ2_2(WebDriver driver) {
		super(driver);

	}

	public EQ2_2 belongToUSNational(Properties n400copies,
			String doYouBelongToUSNational) {
		if (doYouBelongToUSNational.equalsIgnoreCase("yes")
				|| doYouBelongToUSNational.equalsIgnoreCase("no")) {
			System.out.println("2.2-----------------------------------"
					+ doYouBelongToUSNational);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-areYouUSNational"),
						"section-2.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			areYouUSNational = new YesNo(driver, "quiz.areYouUSNational");
			areYouUSNational.setYesOrNo(doYouBelongToUSNational);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ2_2");
			
			 clickContinueInEQ();
		}
		return this;
	}

}

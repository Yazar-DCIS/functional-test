package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_2 extends WizardPage {

	public YesNo outOfUSThreeYears;
	public Sites site;

	public EQ5_2(WebDriver driver) {
		super(driver);

	}

	public EQ5_2 outOfUSThreeYears(Properties n400copies,
			String wereYouOutOfUSFor3Years) {
		if (wereYouOutOfUSFor3Years.equalsIgnoreCase("yes")
				|| wereYouOutOfUSFor3Years.equalsIgnoreCase("no")) {
			System.out.println("5.2-----------------------------------"
					+ wereYouOutOfUSFor3Years);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-outOfUSThreeYears"),
						"section-5.2.1");
				copyValidation.verifyFAQText(
						n400copies.getProperty("eq.faq.question2"),
						n400copies.getProperty("eq.faq.answer2"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			outOfUSThreeYears = new YesNo(driver, "quiz.outOfUSThreeYears");
			outOfUSThreeYears.setYesOrNo(wereYouOutOfUSFor3Years);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ5_2");
			 clickContinueInEQ();
		}
		return this;
	}

	

}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ5_3 extends WizardPage {

	public YesNo outOfUSFiveYears;
	public Sites site;

	public EQ5_3(WebDriver driver) {
		super(driver);

	}

	public EQ5_3 outOfUSFiveYears(Properties n400copies,
			String wereYouOutOfUSFor5Years) {
		if (wereYouOutOfUSFor5Years.equalsIgnoreCase("yes")
				|| wereYouOutOfUSFor5Years.equalsIgnoreCase("no")) {
			System.out.println("5.3-----------------------------------"
					+ wereYouOutOfUSFor5Years);
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-outOfUSFiveYears"),
						"section-5.3.1");
				/*copyValidation.verifyFAQText(
						n400copies.getProperty("eq.faq.question2"),
						n400copies.getProperty("eq.faq.answer2"));*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			outOfUSFiveYears = new YesNo(driver, "quiz.outOfUSFiveYears");
			outOfUSFiveYears.setYesOrNo(wereYouOutOfUSFor5Years);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ5_3");
			 clickContinueInEQ();
		}
		return this;
	}

}

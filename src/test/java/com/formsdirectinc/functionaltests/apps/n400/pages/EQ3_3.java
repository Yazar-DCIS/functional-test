package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for EQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ3_3 extends WizardPage {

	public YesNo greencard6MonthValid;
	public Sites site;

	public EQ3_3(WebDriver driver) {
		super(driver);
	}

	public EQ3_3 greencard6MonthValid(Properties n400copies,
			String isYourGreenCardValidFor6Month) {
		if (isYourGreenCardValidFor6Month.equalsIgnoreCase("yes")
				|| isYourGreenCardValidFor6Month.equalsIgnoreCase("no")) {
			System.out.println("3.3-----------------------------------"
					+ isYourGreenCardValidFor6Month);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-greencard6MonthValid"),
						"section-3.3.1");
				copyValidation.verifyFAQText(
						n400copies.getProperty("eq.faq.question1"),
						n400copies.getProperty("eq.faq.answer1"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			greencard6MonthValid = new YesNo(driver,
					"quiz.greencard6MonthValid");
			greencard6MonthValid.setYesOrNo(isYourGreenCardValidFor6Month);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_3");
			
			 clickContinueInEQ();
		}
		return this;
	}

}

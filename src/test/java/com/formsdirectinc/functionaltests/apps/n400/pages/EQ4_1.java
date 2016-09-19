package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ4_1 extends WizardPage {

	public YesNo greencard4Years9Months;
	public Sites site;

	public EQ4_1(WebDriver driver) {
		super(driver);
	}

	public EQ4_1 greencard4Years9Months(Properties n400copies,
			String isYourGreenCard4Years9Months) {
		if (isYourGreenCard4Years9Months.equalsIgnoreCase("yes")
				|| isYourGreenCard4Years9Months.equalsIgnoreCase("no")) {
			System.out.println("4.1-----------------------------------"
					+ isYourGreenCard4Years9Months);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-greencard4Years9Months"),
						"section-4.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			greencard4Years9Months = new YesNo(driver,"quiz.greencard4Years9Months");
			greencard4Years9Months.setYesOrNo(isYourGreenCard4Years9Months);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ4_1");
			 clickContinueInEQ();
		}
		return this;
	}

}

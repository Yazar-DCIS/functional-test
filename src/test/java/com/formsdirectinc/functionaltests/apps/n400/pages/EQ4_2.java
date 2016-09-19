package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ4_2 extends WizardPage {

	public YesNo greencard6MonthValid;
	public Sites site;

	public EQ4_2(WebDriver driver) {
		super(driver);
	}

	public EQ4_2 greencard6MonthValid(Properties n400copies,
			String isYourGreenCardValidFor6Month) {
		if (isYourGreenCardValidFor6Month.equalsIgnoreCase("yes")
				|| isYourGreenCardValidFor6Month.equalsIgnoreCase("no")) {
			System.out.println("4.2-----------------------------------"
					+ isYourGreenCardValidFor6Month);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-greencard6MonthValid"),
						"section-4.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			greencard6MonthValid = new YesNo(driver,"quiz.greencard6MonthValid");
			greencard6MonthValid.setYesOrNo(isYourGreenCardValidFor6Month);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ4_2");
			 clickContinueInEQ();
		}
		return this;
	}

}

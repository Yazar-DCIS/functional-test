package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_1 extends WizardPage {

	public YesNo greencard2Years9Months;
	public Sites site;

	public EQ3_1(WebDriver driver) {
		super(driver);

	}

	public EQ3_1 greencard2Years9Months(Properties n400copies,
			String isYourGreencard2Years9Months) {
		if (isYourGreencard2Years9Months.equalsIgnoreCase("yes")
				|| isYourGreencard2Years9Months.equalsIgnoreCase("no")) {
			System.out.println("3.1-----------------------------------"
					+ isYourGreencard2Years9Months);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-greencard2Years9Months"),
						"section-3.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			greencard2Years9Months = new YesNo(driver,
					"quiz.greencard2Years9Months");
			greencard2Years9Months.setYesOrNo(isYourGreencard2Years9Months);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_1");
			
			 clickContinueInEQ();
		}
		return this;
	}

}

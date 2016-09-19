package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ4_3 extends WizardPage {

	public YesNo outOfUSThreeYears;
	public Sites site;

	public EQ4_3(WebDriver driver) {
		super(driver);
	}

	public EQ4_3 outOfUSThreeYears(Properties n400copies,
			String wereYouOutOfUSFor3Years) {
		if (wereYouOutOfUSFor3Years.equalsIgnoreCase("yes")
				|| wereYouOutOfUSFor3Years.equalsIgnoreCase("no")) {
			System.out.println("4.3-----------------------------------"
					+ wereYouOutOfUSFor3Years);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-outOfUSThreeYears"),
						"section-4.3.1");
				copyValidation.verifyLearnMoreText(n400copies
						.getProperty("eq-explainthis.4.3AB"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			outOfUSThreeYears = new YesNo(driver,"quiz.physicallyPresent30Months");
			outOfUSThreeYears.setYesOrNo(wereYouOutOfUSFor3Years);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ4_3");
			 clickContinueInEQ();
		}
		return this;
	}

}

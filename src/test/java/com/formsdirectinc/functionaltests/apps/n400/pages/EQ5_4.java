package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_4 extends WizardPage {

	public YesNo outOfUSOneYear;
	public Sites site;

	public EQ5_4(WebDriver driver) {
		super(driver);

	}

	public EQ5_4 outOfUSOneYear(Properties n400copies,
			String wereYouOutOfUSFor1Year) {
		if (wereYouOutOfUSFor1Year.equalsIgnoreCase("yes")
				|| wereYouOutOfUSFor1Year.equalsIgnoreCase("no")) {
			System.out.println("5.4-----------------------------------"
					+ wereYouOutOfUSFor1Year);
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-outOfUSOneYear"),
						"section-5.4.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			outOfUSOneYear = new YesNo(driver, "quiz.outOfUSOneYear");
			outOfUSOneYear.setYesOrNo(wereYouOutOfUSFor1Year);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ5_4");
			 clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_2 extends WizardPage {

	public YesNo liveOutsideUS;
	public Sites site;

	public EQ1_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_2 livedOutsideUS(Properties n400copies,
			String haveYouLiveOutsideUS) {
		if (haveYouLiveOutsideUS.equalsIgnoreCase("yes")
				|| haveYouLiveOutsideUS.equalsIgnoreCase("no")) {
			System.out.println("1.2-----------------------------------"
					+ haveYouLiveOutsideUS);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-liveOutsideUS"),
						"section-1.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			liveOutsideUS = new YesNo(driver, "quiz.liveOutsideUS");
			liveOutsideUS.setYesOrNo(haveYouLiveOutsideUS);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ1_2");
			
			clickContinueInEQ();
		}
		return this;
	}

}

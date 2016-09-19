package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_3 extends WizardPage {

	public YesNo marriedToUSCitizen;
	public Sites site;

	public EQ2_3(WebDriver driver) {
		super(driver);

	}

	public EQ2_3 marriedToUSCitizen(Properties n400copies,
			String areYouMarriedToUSCitizen) {

		if (areYouMarriedToUSCitizen.equalsIgnoreCase("yes")
				|| areYouMarriedToUSCitizen.equalsIgnoreCase("no")) {
			System.out.println("2.3-----------------------------------"
					+ areYouMarriedToUSCitizen);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-marriedToUSCitizen"),
						"section-2.3.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			marriedToUSCitizen = new YesNo(driver, "quiz.marriedToUSCitizen");
			marriedToUSCitizen.setYesOrNo(areYouMarriedToUSCitizen);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ2_3");
			
			
			 clickContinueInEQ();
		}
		return this;
	}

}

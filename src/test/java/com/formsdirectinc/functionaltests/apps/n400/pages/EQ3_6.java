package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ3_6 extends WizardPage {

	public YesNo haveYouMarriedUSCitizen;
	public Sites site;

	public EQ3_6(WebDriver driver) {
		super(driver);
	}

	public EQ3_6 marriedUSCitizen(Properties n400copies,
			String areYouMarriedToUSCitizen) {
		if (areYouMarriedToUSCitizen.equalsIgnoreCase("yes")
				|| areYouMarriedToUSCitizen.equalsIgnoreCase("no")) {
			System.out.println("3.6-----------------------------------"
					+ areYouMarriedToUSCitizen);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-haveYoumarriedUSCitizen"),
						"section-3.6.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			haveYouMarriedUSCitizen = new YesNo(driver,	"quiz.haveYoumarriedUSCitizen");
			haveYouMarriedUSCitizen.setYesOrNo(areYouMarriedToUSCitizen);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_6");
			 clickContinueInEQ();
		}
		return this;
	}

}

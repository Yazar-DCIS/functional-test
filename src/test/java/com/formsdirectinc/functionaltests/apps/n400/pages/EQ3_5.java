package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_5 extends WizardPage {

	public YesNo spouseHasBeenUSCitizen;
	public Sites site;

	public EQ3_5(WebDriver driver) {
		super(driver);

	}

	public EQ3_5 spouseHasBeenUSCitizen(Properties n400copies,
			String hasYourSpouseBeenAsUSCitizen) {
		if (hasYourSpouseBeenAsUSCitizen.equalsIgnoreCase("yes")
				|| hasYourSpouseBeenAsUSCitizen.equalsIgnoreCase("no")) {
			System.out.println("3.5-----------------------------------"
					+ hasYourSpouseBeenAsUSCitizen);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-spouseHasBeenUSCitizen"),
						"section-3.5.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			spouseHasBeenUSCitizen = new YesNo(driver,"quiz.spouseHasBeenUSCitizen");
			spouseHasBeenUSCitizen.setYesOrNo(hasYourSpouseBeenAsUSCitizen);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_5");
			 clickContinueInEQ();
		}
		return this;
	}

}

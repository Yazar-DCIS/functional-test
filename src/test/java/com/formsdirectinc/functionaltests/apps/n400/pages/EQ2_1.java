package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for EQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ2_1 extends WizardPage {

	public YesNo permanentResidentHolder;
	public Sites site;

	public EQ2_1(WebDriver driver) {
		super(driver);

	}

	public EQ2_1 permanentResidentHolder(Properties n400copies,
			String areYouPermanentResident) {
		if (areYouPermanentResident.equalsIgnoreCase("yes")
				|| areYouPermanentResident.equalsIgnoreCase("no")) {
			System.out.println("2.1-----------------------------------"
					+ areYouPermanentResident);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-permanentResidentHolder"),
						"section-2.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			permanentResidentHolder = new YesNo(driver,
					"quiz.permanentResidentHolder");

			permanentResidentHolder.setYesOrNo(areYouPermanentResident);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ2_1");
			
			 clickContinueInEQ();
		}
		return this;
	}


}

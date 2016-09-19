package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


/**
 * Page model for EQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ3_2 extends WizardPage {

	public YesNo specifiedEmploymentEngage;
	public Sites site;

	public EQ3_2(WebDriver driver) {
		super(driver);
	}

	public EQ3_2 specifiedEmploymentEngage(Properties n400copies,
			String areYouEngagedInEmployment) {
		if (areYouEngagedInEmployment.equalsIgnoreCase("yes")
				|| areYouEngagedInEmployment.equalsIgnoreCase("no")) {
			System.out.println("3.2-----------------------------------"
					+ areYouEngagedInEmployment);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(n400copies
						.getProperty("eqLabel-specifiedEmploymentEngage"),
						"section-3.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			specifiedEmploymentEngage = new YesNo(driver,
					"quiz.specifiedEmploymentEngage");
			specifiedEmploymentEngage.setYesOrNo(areYouEngagedInEmployment);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_2");
			
			 clickContinueInEQ();
		}
		return this;
	}

}

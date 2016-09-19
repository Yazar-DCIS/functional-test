package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_4 extends WizardPage {

	public YesNo physicallyPresent18Months;
	public Sites site;

	public EQ3_4(WebDriver driver) {
		super(driver);

	}

	public EQ3_4 physicallyPresent18Months(Properties n400copies,
			String wereYouPhysicallyPresentInUSFor18Months) {
		if (wereYouPhysicallyPresentInUSFor18Months.equalsIgnoreCase("yes")
				|| wereYouPhysicallyPresentInUSFor18Months
						.equalsIgnoreCase("no")) {
			System.out.println("3.4-----------------------------------"
					+ wereYouPhysicallyPresentInUSFor18Months);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation
						.verifyPageLabelText(
								n400copies
										.getProperty("eqLabel-physicallyPresent18Months")
										+ " "
										+ n400copies
												.getProperty("label-LearnMore"),
								"section-3.4.1");
				copyValidation.verifyLearnMoreText(n400copies
						.getProperty("eq-explainthis.3.4AB"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			physicallyPresent18Months = new YesNo(driver,"quiz.physicallyPresent18Months");
			physicallyPresent18Months.setYesOrNo(wereYouPhysicallyPresentInUSFor18Months);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ3_4");
			
			 clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5_1 extends WizardPage {

	private MultiRadioOptions livingOutsideUS;

	public SQ1_5_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_1 livingAbroad_applicantMilitary(Properties n400copies,
			String reasonForLivingAbroad) {

		if (reasonForLivingAbroad.equalsIgnoreCase("inMilitaryDuty")
				|| reasonForLivingAbroad
						.equalsIgnoreCase("spouseInMilitaryDuty")
				|| reasonForLivingAbroad.equalsIgnoreCase("workForUS")
				|| reasonForLivingAbroad.equalsIgnoreCase("none")) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			try {

				copyValidation.verifyPageTableHeader(n400copies
						.getProperty("SQ-1.5.1.pageheader"));
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("SQ-1.5.1.pagetext.1"),
						"section-1.5.1.1");
				for (int i = 1; i <= 4; i++) {
					copyValidation.verifySubLabelsSpanText(
							n400copies.getProperty("SQ-1.5.1.pagetext.2." + i),
							"section-1.5.1.1", i - 1);
				}
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			livingOutsideUS = new MultiRadioOptions(driver,
					"applicationData-formSpecific.livingAbroad");

			System.out.println(reasonForLivingAbroad);

			if (reasonForLivingAbroad.equalsIgnoreCase("inMilitaryDuty")) {
				livingOutsideUS.selectOption(1);
			}

			else if (reasonForLivingAbroad.equalsIgnoreCase("spouseInMilitaryDuty")) {
				livingOutsideUS.selectOption(2);
			}

			else if (reasonForLivingAbroad.equalsIgnoreCase("workForUS")) {
				livingOutsideUS.selectOption(3);
			}

			else if (reasonForLivingAbroad.equalsIgnoreCase("none")) {
				livingOutsideUS.selectOption(4);
			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_1");

			 clickContinueInSQ();
		}
		return this;
	}

}

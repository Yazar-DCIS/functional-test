package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ3_6 extends WizardPage

{

	public Sites site;

	public YesNo legitimate;

	public EQ3_6(WebDriver driver) {
		super(driver);

	}

	public EQ3_6 wasLegimate(Properties n600copies, String legimateStatus) {

		if (!legimateStatus.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.6"), "section-3.6.1");
				copyValidation.verifyLearnMoreText(n600copies
						.getProperty("label.learnMore.eq3.6"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			legitimate = new YesNo(driver, "quiz.legitimate");
			legitimate.setYesOrNo(legimateStatus);
			
			saveScreenShot("n600", "EQ3_6"); clickContinueInEQ();
		}
		return this;
	}

}

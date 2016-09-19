package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_8 extends WizardPage

{

	public Sites site;

	public YesNo resideAfterLPR;

	public EQ3_8(WebDriver driver) {
		super(driver);

	}

	public EQ3_8 afterAdmission_ResidedRegularly(Properties n600copies,
			String regularResidentAfterAdmission) {

		if (!regularResidentAfterAdmission.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.8"), "section-3.8.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			resideAfterLPR = new YesNo(driver, "quiz.resideAfterLPR");
			resideAfterLPR.setYesOrNo(regularResidentAfterAdmission);
			

			saveScreenShot("n600", "EQ3_8"); clickContinueInEQ();
		}
		return this;
	}

}

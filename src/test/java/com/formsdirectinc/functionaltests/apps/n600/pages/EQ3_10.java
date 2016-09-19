package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_10 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_10 extends WizardPage

{

	public Sites site;
	public YesNo motherNaturalize;

	public EQ3_10(WebDriver driver) {
		super(driver);

	}

	public EQ3_10 motherNaturalizedStatus(Properties n600copies, String status) {

		if (!status.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.10"),
						"section-3.10.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			motherNaturalize = new YesNo(driver, "quiz.motherNaturalize");
			motherNaturalize.setYesOrNo(status);
			saveScreenShot("n600", "EQ3_10"); clickContinueInEQ();
		}
		return this;
	}

}

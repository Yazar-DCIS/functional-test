package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1 extends WizardPage {

	public YesNo ageAbove18;
	public Sites site;

	public EQ1_1(WebDriver driver) {
		super(driver);

	}

	
	public EQ1_1 ageAbove18(Properties n400copies, String isYourAgeAbove18) {

		
		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation.getPageTitle();
			copyValidation.verifyPageLabelText(
					n400copies.getProperty("eqLabel-above18YearsOrOlder"),
					"section-1.1.1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ageAbove18 = new YesNo(driver, "quiz.above18YearsOrOlder");
		ageAbove18.setYesOrNo(isYourAgeAbove18);
		saveScreenShot("n400", "EQ1_1");
		clickContinueInEQ();

		return this;
	}

}

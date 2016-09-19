package com.formsdirectinc.functionaltests.apps.n600.pages;

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

	public YesNo wereYouBornOutsideTheUS;
	public Sites site;

	public EQ1_1(WebDriver driver) {
		super(driver);

	}

	public EQ1_1 bornOutsideUS(Properties n600copies, String bornOutOfUS) {

		if (bornOutOfUS.equalsIgnoreCase("Yes")
				|| bornOutOfUS.equalsIgnoreCase("No")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.getPageTitle();
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq1.1"), "section-1.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			wereYouBornOutsideTheUS = new YesNo(driver, "quiz.bornOutsideUS");
			wereYouBornOutsideTheUS.setYesOrNo(bornOutOfUS);
			
			saveScreenShot("n600", "EQ1_1"); clickContinueInEQ();
		}
		return this;
	}

}

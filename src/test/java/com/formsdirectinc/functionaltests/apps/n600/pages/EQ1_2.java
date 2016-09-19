package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {
	public Sites site;
	public YesNo doYouRegularlyResideAbroad;

	public EQ1_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_2 residentStatus(Properties n600copies,
			String regularAbroadResident) {

		if (!regularAbroadResident.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq1.2"), "section-1.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			doYouRegularlyResideAbroad = new YesNo(driver,
					"quiz.placeOfResidence");
			doYouRegularlyResideAbroad.setYesOrNo(regularAbroadResident);
			saveScreenShot("n600", "EQ1_2"); clickContinueInEQ();
		}
		return this;
	}

}

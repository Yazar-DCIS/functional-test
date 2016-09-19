package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_9 extends WizardPage

{

	public Sites site;

	public YesNo bornWedlock;

	public EQ3_9(WebDriver driver) {
		super(driver);

	}

	public EQ3_9 born_OutOfWedlock(Properties n600copies,
			String bornAfterWedlock) {
		if (!bornAfterWedlock.equalsIgnoreCase("NA")) {
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.9"), "section-3.9.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			bornWedlock = new YesNo(driver, "quiz.bornWedlock");
			bornWedlock.setYesOrNo(bornAfterWedlock);
			
			saveScreenShot("n600", "EQ3_9"); clickContinueInEQ();
		}
		return this;
	}

}

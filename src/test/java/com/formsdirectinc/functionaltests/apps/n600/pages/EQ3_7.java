package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ3_7 extends WizardPage

{

	public Sites site;

	public YesNo bothParentsNaturalize;

	public EQ3_7(WebDriver driver) {
		super(driver);

	}

	public EQ3_7 bothParents_Naturalized(Properties n600copies,
			String parentsNaturalized) {

		if (!parentsNaturalized.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.7"), "section-3.7.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			bothParentsNaturalize = new YesNo(driver, "quiz.bothPNaturalize");
			bothParentsNaturalize.setYesOrNo(parentsNaturalized);
			saveScreenShot("n600", "EQ3_7"); clickContinueInEQ();
		}
		return this;
	}

}

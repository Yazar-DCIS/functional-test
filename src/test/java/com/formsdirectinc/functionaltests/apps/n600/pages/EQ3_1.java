package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ3_1 extends WizardPage {

	// EQ-3.1
	public Sites site;
	public YesNo wereYouBornToUSCitizenParents;

	public EQ3_1(WebDriver driver) {
		super(driver);

	}

	public EQ3_1 bornToUSParents(Properties n600copies, String bornToUSParent) {

		if (!bornToUSParent.equalsIgnoreCase("NA")) {
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.1"), "section-3.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			wereYouBornToUSCitizenParents = new YesNo(driver,"quiz.borntoUSCitizens");
			wereYouBornToUSCitizenParents.setYesOrNo(bornToUSParent);
			
			saveScreenShot("n600", "EQ3_1"); clickContinueInEQ();
		}
		return this;
	}

}

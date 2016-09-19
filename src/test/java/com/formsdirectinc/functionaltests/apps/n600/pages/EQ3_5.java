package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_5 extends WizardPage

{

	public Sites site;
	public YesNo adoptedByUSCitizenParent;

	public EQ3_5(WebDriver driver) {
		super(driver);

	}

	public EQ3_5 adopted_ByUSCitizenParent(Properties n600copies,
			String adoptedCitizen) {

		if (!adoptedCitizen.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.5"), "section-3.5.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			adoptedByUSCitizenParent = new YesNo(driver,"quiz.adoptedByUSCitizenP");
			adoptedByUSCitizenParent.setYesOrNo(adoptedCitizen);
			

			saveScreenShot("n600", "EQ3_5"); clickContinueInEQ();
		}

		return this;
	}

}

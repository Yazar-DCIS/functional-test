package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_3 extends WizardPage {

	public Sites site;
	public YesNo bornToAtleastOneUSCitizen;

	public EQ3_3(WebDriver driver) {
		super(driver);

	}

	public EQ3_3 oneParentIsUSCitizen(Properties n600copies,
			String parentUSCitizen) {
		if (!parentUSCitizen.equalsIgnoreCase("NA")) {
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.3"), "section-3.3.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			bornToAtleastOneUSCitizen = new YesNo(driver,"quiz.bornToAtleastOneUSCitizen");
			bornToAtleastOneUSCitizen.setYesOrNo(parentUSCitizen);
			
			saveScreenShot("n600", "EQ3_3"); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_2 extends WizardPage {
	public YesNo priorToBirthAtLeastOneParentHadUSResidence;
	public Sites site;

	public EQ3_2(WebDriver driver) {
		super(driver);

	}

	public EQ3_2 atleastOneParent_haveResidence(Properties n600copies,
			String parentHaveResident) {

		if (!parentHaveResident.equalsIgnoreCase("NA")) {
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.2"), "section-3.2.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			priorToBirthAtLeastOneParentHadUSResidence = new YesNo(driver,"quiz.priorBirthPResidence");
			priorToBirthAtLeastOneParentHadUSResidence.setYesOrNo(parentHaveResident);
		
			saveScreenShot("n600", "EQ3_2"); clickContinueInEQ();
		}
		return this;
	}

}

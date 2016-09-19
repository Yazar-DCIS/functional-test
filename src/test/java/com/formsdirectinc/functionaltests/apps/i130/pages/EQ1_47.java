package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_47 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_47 extends WizardPage {

	public YesNo siblingRelatedByAdoption;

	public EQ1_47(WebDriver driver) {
		super(driver);

	}

	public EQ1_47 siblingRelatedByAdoption(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			siblingRelatedByAdoption = new YesNo(driver,
					"quiz.siblingRelatedByAdoption");

			siblingRelatedByAdoption.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

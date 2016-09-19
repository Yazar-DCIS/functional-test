package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_8_1 extends WizardPage {

	public YesNo childInspectedLastEntryUS;

	public EQ1_8_1(WebDriver driver) {
		super(driver);

	}

	public EQ1_8_1 childInspectedLastEntryUS(String answer, Properties data) {

		if (!answer.equalsIgnoreCase("NA")) {
			
			childInspectedLastEntryUS = new YesNo(driver,
					"quiz.childInspectedLastEntryUS");

			childInspectedLastEntryUS.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

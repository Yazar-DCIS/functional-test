package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_43_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_43_3 extends WizardPage {

	public YesNo brotherOrSisterInspectedLastEntryUS;

	public EQ1_43_3(WebDriver driver) {
		super(driver);

	}

	public EQ1_43_3 brotherOrSisterInspectedLastEntryUS(String answer,
			Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			brotherOrSisterInspectedLastEntryUS = new YesNo(driver,	"quiz.brotherOrSisterInspectedLastEntryUS");
			brotherOrSisterInspectedLastEntryUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

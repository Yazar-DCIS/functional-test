package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_25_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_25_1 extends WizardPage {

	public YesNo lawfulPermanentResident;

	public EQ1_25_1(WebDriver driver) {
		super(driver);

	}

	public EQ1_25_1 lawfulPermanentResident(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			lawfulPermanentResident = new YesNo(driver,
					"quiz.lawfulPermanentResident");
			lawfulPermanentResident.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

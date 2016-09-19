package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_28 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_28 extends WizardPage {

	public YesNo presentInUS;

	public EQ1_28(WebDriver driver) {
		super(driver);

	}

	public EQ1_28 physicallyPresent(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			presentInUS = new YesNo(driver, "quiz.physicallyPresent");

			presentInUS.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}
